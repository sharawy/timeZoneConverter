/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timezone.commons;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 *
 * @author abdalrahman.sharawy
 */
@JsonSerialize
public class JsonResponse { 
private String msg;
private Object data;
private List<FieldError> errors;
 public JsonResponse(String msg) {
    this.msg = msg;
    this.data = null;
  }
 public JsonResponse() {
    this.msg = "";
    this.data = null;
  }
  public List<FieldError> getErrors() {
    return errors;
  }

  public void setErrors(List<FieldError> errors) {
    this.errors = errors;
  }
 

  public Object getData() {
    return data;
  }

  public void setData(Object object) {
    this.data = object;
  }
  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}

