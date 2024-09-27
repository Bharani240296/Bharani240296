package com.SmsSending.SentSms.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsRequest {
    private static final Logger logger = LoggerFactory.getLogger(SmsRequest.class);

    private String to;
    private String message;

    // Default constructor
    public SmsRequest() {
        logger.info("SmsRequest object created with no parameters");
    }

    // Constructor with parameters
    public SmsRequest(String to, String message) {
        this.to = to;
        this.message = message;
        logger.info("SmsRequest object created: to={}, message={}", to, message);
    }

    // Getters and Setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        logger.info("Setting 'to' field: {}", to);
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        logger.info("Setting 'message' field: {}", message);
        this.message = message;
    }
}
