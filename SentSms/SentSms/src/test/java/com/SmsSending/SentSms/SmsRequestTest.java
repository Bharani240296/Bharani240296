package com.SmsSending.SentSms;

import com.SmsSending.SentSms.model.SmsRequest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SmsRequestTest {

    @Test
    public void testDefaultConstructor() {
        // Test the default constructor
        SmsRequest smsRequest = new SmsRequest();

        // Assertions to check default values
        assertThat(smsRequest.getTo()).isNull();
        assertThat(smsRequest.getMessage()).isNull();
    }

    @Test
    public void testConstructorWithParameters() {
        // Test the constructor with parameters
        SmsRequest smsRequest = new SmsRequest("+916968569585", "Hello, this is a test message!");

        // Assertions to check that the fields are set correctly
        assertThat(smsRequest.getTo()).isEqualTo("+916968569585");
        assertThat(smsRequest.getMessage()).isEqualTo("Hello, this is a test message!");
    }

    @Test
    public void testSetters() {
        // Test setters
        SmsRequest smsRequest = new SmsRequest();
        smsRequest.setTo("+15551234567");
        smsRequest.setMessage("Test message");

        // Assertions to verify the setters work as expected
        assertThat(smsRequest.getTo()).isEqualTo("+15551234567");
        assertThat(smsRequest.getMessage()).isEqualTo("Test message");
    }

    @Test
    public void testSettersWithEmptyValues() {
        // Test setters with empty values
        SmsRequest smsRequest = new SmsRequest();
        smsRequest.setTo("");
        smsRequest.setMessage("");

        // Assertions to verify the fields can handle empty strings
        assertThat(smsRequest.getTo()).isEqualTo("");
        assertThat(smsRequest.getMessage()).isEqualTo("");
    }

    @Test
    public void testSettersWithNullValues() {
        // Test setters with null values
        SmsRequest smsRequest = new SmsRequest();
        smsRequest.setTo(null);
        smsRequest.setMessage(null);

        // Assertions to verify the fields can handle null values
        assertThat(smsRequest.getTo()).isNull();
        assertThat(smsRequest.getMessage()).isNull();
    }
}

