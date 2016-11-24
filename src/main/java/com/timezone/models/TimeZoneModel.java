/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.timezone.models;

import com.timezone.commons.Constants;
import com.timeZone.validators.annotations.StringTimeDate;
import javax.validation.constraints.NotNull;


/**
 *
 * @author abdalrahman.sharawy
 */
public class TimeZoneModel {
    @NotNull(message = Constants.messages.timeNotNull)
    @StringTimeDate(format = Constants.timeDateFormat)
    private String time;
    
    @NotNull
    private String zoneId;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }
    
}
