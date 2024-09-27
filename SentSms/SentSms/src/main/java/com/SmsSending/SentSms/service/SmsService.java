package com.SmsSending.SentSms.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    // Initialize Twilio in a method (not the constructor)
    private void initializeTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String to, String message) {
        // Ensure Twilio is initialized
        initializeTwilio();

        // Create and send SMS using Twilio
        Message.creator(new PhoneNumber(to), new PhoneNumber(fromPhoneNumber), message).create();
    }
}


