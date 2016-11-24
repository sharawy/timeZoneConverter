/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timezone.services;

import com.timezone.models.TimeZoneModel;
import java.util.Date;

/**
 *
 * @author abdalrahman.sharawy
 */
public interface DateService {

    public Date convertToTimeZone(TimeZoneModel timeZone);

    public String formateDate(Date date, String format);
}
