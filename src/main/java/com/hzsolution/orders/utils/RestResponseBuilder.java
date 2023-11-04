package com.hzsolution.orders.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseBuilder {

  public static ResponseEntity buildSuccess(JSONObject jsonpObject, String serviceRefId) {
    try {
      JSONObject responseJSON = new JSONObject();
      responseJSON.put("serviceRefId", serviceRefId);
      responseJSON.put("status","200");
      jsonpObject.put("context", responseJSON);
    } catch (JSONException e ) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity(jsonpObject.toString(), HttpStatus.OK);
  }
}
