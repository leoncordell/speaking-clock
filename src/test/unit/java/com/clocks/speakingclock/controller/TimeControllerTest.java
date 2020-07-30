package com.clocks.speakingclock.controller;

import com.clocks.speakingclock.TimeObj;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TimeController.class)
class TimeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public  void doTestPostTime() throws Exception {
       MvcResult result = mvc.perform( MockMvcRequestBuilders
                .post("/time/")
                .content(asJsonString(new TimeObj("7:12")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assert(content.contains("seven"));
    }


    @Test
    public  void doTestGetTimer() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/timer")
                .content(asJsonString(new TimeObj("5:15")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assert (content.contains("fifteen"));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}