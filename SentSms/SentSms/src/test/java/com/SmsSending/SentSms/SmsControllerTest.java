package com.SmsSending.SentSms;
import com.SmsSending.SentSms.controller.SmsController;
import com.SmsSending.SentSms.model.SmsRequest;
import com.SmsSending.SentSms.service.SmsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SmsController.class)
public class SmsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SmsService smsService; // Mock the service

    @InjectMocks
    private SmsController smsController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendSmsSuccess() throws Exception {
        // Mock behavior of the service
        doNothing().when(smsService).sendSms(anyString(), anyString());

        SmsRequest smsRequest = new SmsRequest("+916968569585", "Test SMS message");

        mockMvc.perform(post("/api/sms/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(smsRequest)))
                .andExpect(status().isOk());
    }
}



