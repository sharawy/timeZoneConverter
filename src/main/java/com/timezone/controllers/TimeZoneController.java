/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timezone.controllers;

import com.timezone.commons.BaseResource;
import com.timezone.commons.Constants;
import com.timezone.commons.JsonResponse;
import com.timezone.models.TimeZoneModel;
import com.timezone.services.DateService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author abdalrahman.sharawy
 */
@EnableWebMvc
@Controller

public class TimeZoneController extends BaseResource {

    @Autowired
    DateService dateService;

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping(value = Constants.RestApi.getTimeZoneUrl, method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity getTimeZones() {
        JsonResponse response = new JsonResponse();

        response.setMsg(Constants.messages.success);
        response.setData(java.util.TimeZone.getAvailableIDs());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = Constants.RestApi.convertTimeZoneUrl, method = RequestMethod.GET)
    public ResponseEntity convertTimeZone(@ModelAttribute @Valid TimeZoneModel timeZone, BindingResult result) {
        JsonResponse response = new JsonResponse(Constants.messages.failed);
        if (result.hasErrors()) {
            response.setErrors(result.getFieldErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        String formatedTimeDate;
        Date convertedTime = dateService.convertToTimeZone(timeZone);

        formatedTimeDate = dateService.formateDate(convertedTime, Constants.timeDateFormat);
        response.setMsg(Constants.messages.success);
        response.setData(formatedTimeDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
