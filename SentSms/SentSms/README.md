SMS Sending Application

A Spring Boot application that allows users to send SMS messages via an API. This project demonstrates the integration of an SMS service into a Java Spring Boot application, with endpoints to send messages and handle HTTP requests.
Table of Contents

    Features
    Getting Started
        Prerequisites
        Installation
    Usage
        Sending an SMS
    API Endpoints
    Testing
    Technologies Used
    Contributing
    License
    Contact

Features

    Sends SMS messages using the Twilio API (or other SMS service providers).
    RESTful API for interacting with the application.
    Test cases to ensure functionality.

Getting Started
Prerequisites

To run this project, you'll need the following installed:

    Java 11 or later
    Maven or Gradle (for dependency management and building the project)
    Twilio Account (or another SMS service provider)

Installation

    Clone the repository:

    bash

git clone https://github.com/your-username/sms-sending-application.git

Navigate to the project directory:

bash

cd sms-sending-application

Configure the application:

Create a application.properties file in src/main/resources/ and set the following properties:

properties

twilio.account.sid=your-twilio-account-sid
twilio.auth.token=your-twilio-auth-token
twilio.phone.number=your-twilio-phone-number

Build the project:

bash

mvn clean install

Run the application:

bash

    mvn spring-boot:run

    The application will start and be available at http://localhost:8080.

Usage
Sending an SMS

To send an SMS message, make a POST request to the /api/sms/send endpoint with the recipient's phone number and message.

Example request body:

json

{
"to": "+916968569585",
"message": "Hello, this is a test message"
}

Postman Example

    Open Postman.

    Set the request method to POST.

    Enter the URL: http://localhost:8080/api/sms/send.

    Add the following JSON body in the Body tab:

    json

    {
        "to": "+916968569585",
        "message": "Hello, this is a test message"
    }

    Send the request.

If successful, you'll receive a response:

SMS sent successfully!

API Endpoints
Method	Endpoint	Description
POST	/api/sms/send	Sends an SMS message.
Testing

Unit tests are written to ensure that the functionality works as expected. You can run the tests using the following command:

bash

mvn test

Example Test Class

A simple test case for the SMS controller can be found in SmsControllerTest.java. It mocks the SmsService to test controller logic without actually sending SMS messages.

java

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SmsController.class)
public class SmsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SmsService smsService;

    @Test
    public void testSendSmsSuccess() throws Exception {
        doNothing().when(smsService).sendSms(anyString(), anyString());

        mockMvc.perform(post("/api/sms/send")
                        .contentType("application/json")
                        .content("{ \"to\": \"+916968569585\", \"message\": \"Test SMS message\" }"))
                .andExpect(status().isOk());
    }
}

Technologies Used

    Java - Backend programming language.
    Spring Boot - Backend framework for Java.
    Twilio API - SMS service provider (or another provider can be used).
    Maven - Dependency management and build tool.
    JUnit 5 - For unit testing.

Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

    Fork the repository.
    Create a new branch (git checkout -b feature-branch).
    Make your changes.
    Commit your changes (git commit -m 'Add feature').
    Push to the branch (git push origin feature-branch).
    Create a pull request.

License

This project is licensed under the MIT License. See the LICENSE file for details.
Contact

If you have any questions, feel free to reach out:

    Email: your.email@example.com
    GitHub: your-username

Notes:

    Replace the placeholders like your-username, your.email@example.com, and your-twilio-account-sid with your actual details.
    This README.md should be placed at the root of your project, and it will automatically display when viewing the project on GitHub.