package com.timezone.Controllers;


import com.timezone.controllers.TimeZoneController;
import com.timezone.services.impl.DateServiceImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TimeZoneController.class,DateServiceImpl.class})
@WebAppConfiguration
public class TimeZoneControllerTest {

 private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void testGetTimeZones() throws Exception {
       System.out.println("GetTimeZones");
               this.mockMvc.perform(get("/timeZones"))
                       .andExpect(status().isOk())
                       .andExpect(content().contentType("application/json"));
     
    }
@Test
    public void testConvertTimeZone() throws Exception {
       System.out.println("ConvertTimeZone");
      
      
              MvcResult result =  this.mockMvc.perform(get("/convertTimeZone")
                       .param("zoneId", "Asia/Riyadh")
                       .param("time", "2016-11-16 04:06"))
                       .andExpect(status().isOk())
                       .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
              String content = result.getResponse().getContentAsString();
              String expected="{\"msg\":\"success\",\"data\":\"2016-12-16 15:06\",\"errors\":null}";
              assertEquals(expected, content);
     
    }
}