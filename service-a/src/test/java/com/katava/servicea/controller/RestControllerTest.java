package com.katava.servicea.controller;

import com.katava.servicea.service.RabbitSender;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.katava.servicea.service.serviceImpl.RabbitSenderImpl;

public class RestControllerTest
{
    @Mock
    private RabbitSender rabbitSender;

    @InjectMocks
    private RestController restController;

    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
    }

    @Test
    public void httpCorrectMessageTest() throws Exception
    {
        Double amount = 15.;
        String currency = "EUR";

        mockMvc.perform(post("/message").content("{\"amount\":\"" + amount + "\",\"currency\":\"" + currency + "\"}")
            .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(rabbitSender, times(1)).send(any());
    }

    @Test
    public void httpWrongMessageTest() throws Exception
    {
        Double amount = 15.;
        String currency = "HRK";

        mockMvc.perform(post("/message").content("{\"amount\":\"" + amount + "\",\"currency\":\"" + currency + "\"}")
            .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
        }
}
