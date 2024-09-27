package com.SmsSending.SentSms.controller;


import com.SmsSending.SentSms.model.SmsRequest;
import com.SmsSending.SentSms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public String sendSms(@RequestBody SmsRequest smsRequest) {
        try {
            // Log received request
            System.out.println("Received SMS request: to=" + smsRequest.getTo() + ", message=" + smsRequest.getMessage());

            // Send SMS
            smsService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
            return "SMS sent successfully!";
        } catch (Exception e) {
            return "Failed to send SMS: " + e.getMessage();
        }
    }
}


