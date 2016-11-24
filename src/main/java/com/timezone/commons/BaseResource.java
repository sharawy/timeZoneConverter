/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.timezone.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author abdalrahman.sharawy
 */

public class BaseResource {
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity handleClientErrors(Exception e) {
return new ResponseEntity(new JsonResponse(Constants.messages.illegalValues),
            HttpStatus.BAD_REQUEST) ;
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleServerErrors(Exception e) {
    return new ResponseEntity(new JsonResponse(Constants.messages.internalError),
            HttpStatus.INTERNAL_SERVER_ERROR) ;
  }
  

}
