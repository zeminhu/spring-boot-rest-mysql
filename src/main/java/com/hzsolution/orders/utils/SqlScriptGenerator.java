package com.hzsolution.orders.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// purpose : to parse spreadsheet data and generate SQL
public class SqlScriptGenerator {
    private static final Logger logger = LoggerFactory.getLogger(SqlScriptGenerator.class);

    private String dataFilePath = "iso-data.txt";
    private String templateFilePath = "template.sql";
    private String outFilePath = "iso-data-insert.sql";

    public String convertDate(String inDate) {
        // "yyyy-MM-dd HH:mm:ss.S": "2011-01-18 00:00:00.0"
        // "[MM][M]/[dd][d]/[yyyy][yy]" : "1/1/1990"
        // source date format: 1/1/1990
        // target date format: 31-DEC-2099 12.00.00.0000 AM
        LocalDateTime localDateTime = LocalDateTime.parse(inDate, DateTimeFormatter.ofPattern("[MM][M]/[dd][d]/[yyyy][yy] HH:mm:ss.S"));
        String outDate = localDateTime.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH.mm.ss")).toString().toUpperCase(Locale.ROOT) + " AM";
        return outDate;
    }

    public void generateISOLangData() {
        File dataFile = null;
        List<String> result = new ArrayList<String>();

        try {
            String[] template = readTemplate(templateFilePath);
            String[] data = readData(dataFilePath);
            for(int i = 0; i < data.length; i++) {
                Map<String, String> entryMap = parse(replaceSpecialChars(data[i]));
                String code = entryMap.get("code");
                String shortDesc = entryMap.get("short");
                String longDesc = entryMap.get("long");
                for(int j = 0; j < template.length; j++) {
                    String workCopy = template[j];
                    String resultLine = workCopy;
                    if(workCopy.contains("<record>")) {
                        resultLine = workCopy.replace("<record>", "" + (i + 1));
                        workCopy = resultLine;
                    }

                    if(workCopy.contains("<code>")) {
                        resultLine = workCopy.replace("<code>", code);
                    } else if(workCopy.contains("<short-desc>")) {
                        resultLine = workCopy.replace("<short-desc>", shortDesc);
                    } else if(workCopy.contains("<long-desc>")) {
                        resultLine = workCopy.replace("<long-desc>", longDesc);
                    };

                    result.add(resultLine);
                }

            }
            writeToFile(outFilePath, result.toArray(new String[0]));

        } catch (Exception e) {
            logger.error("IO exception" + e);
        }
    }

    public String replaceSpecialChars(String value) {
        // put all special chars here
        return value.replace("A", "A").replace("'", " ").replace("@", "at");
    }

    public Map<String, String> parse(String line) {
        // designed pattern for "aaa|Ghotue|Ghotuo|1/1/1990|12/31/2099"
        Map<String, String> map = new HashMap<>();
        String delimiter = "|";
        int currIndex = 0, lastIndex = 0, endIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            currIndex = line.indexOf(delimiter, lastIndex);
            if(currIndex == -1) {
                endIndex = line.length();
            } else {
                endIndex = currIndex;
            }
            switch (count) {
                case 0: map.put("code", line.substring(0, endIndex)); break;
                case 1: map.put("short", line.substring(lastIndex, endIndex)); break;
                case 2: map.put("long", line.substring(lastIndex, endIndex)); break;
                case 3: map.put("effectiveDate", line.substring(lastIndex, endIndex)); break;
                case 4: map.put("terminationDate", line.substring(lastIndex, endIndex)); break;
            }

            if(currIndex == -1)
                break;
            else {
                lastIndex = currIndex + delimiter.length();
                count ++;
            }
        }
        return map;
    }

    public void writeToFile(String path, String[] lines) {
        File dataFile = null;
        try {
            dataFile = new ClassPathResource(path).getFile();
            BufferedWriter writer = Files.newBufferedWriter(dataFile.toPath(), StandardCharsets.UTF_8);
            for(int i = 0; i < lines.length; i++)
                writer.write(lines[i] + "\n");
            writer.flush();
        } catch (Exception e) {
            logger.error("IO Exception " + e);
        }
    }

    public String[] readData(String dataFilePath) {
        File dataFile = null;
        try {
            dataFile = new ClassPathResource(dataFilePath).getFile();
            String[] lines = Files.readAllLines(dataFile.toPath(), StandardCharsets.UTF_8).toArray(new String[0]);
            logger.info("number of lines read: " + lines.length);
            return lines;
        } catch (Exception e) {
            logger.error("IO exception: " + e);
        }
        return null;
    }

    public String[] readTemplate(String templateFilePath) {
        File dataFile = null;
        try {
            dataFile = new ClassPathResource(templateFilePath).getFile();
            String[] lines = Files.readAllLines(dataFile.toPath(), StandardCharsets.UTF_8).toArray(new String[0]);
            logger.info("number of lines read: " + lines.length);
            return lines;
        } catch (Exception e) {
            logger.error("IO exception: " + e);
        }
        return null;
    }

}
