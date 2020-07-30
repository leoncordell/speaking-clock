package com.clocks.speakingclock;


import com.clocks.speakingclock.controller.TimeController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.ByteArrayInputStream;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainTest  {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TimeController controller;

    @Autowired
    Main main;

//    @Test
//    public void testContextLoads()  {
//        assert(controller !=null);
//    }
//
//    @Test
//    public void testContextLoadsA() throws Exception {
//        this.mockMvc.perform(get("/show/")).andExpect(status().isOk());
//    }

    @Test
    public  void mainAppTest(){
        Main main = new Main();
        System.setIn(new ByteArrayInputStream("Q".getBytes()));
        main.main(new String[2]);

    }



}