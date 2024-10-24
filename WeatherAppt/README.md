# Weather App

## Overview

The Weather App is a Spring Boot application that provides weather information for various cities. Users can retrieve current weather data by specifying a city name. The application utilizes an external weather service API to fetch real-time weather data and presents it in a user-friendly format.

## Features

- Get current weather information including temperature, humidity, weather description, and wind speed for any city.
- Error handling for invalid city names and missing parameters.
- RESTful API with JSON responses.

## Technologies Used

- Spring Boot
- Spring Web
- Mockito (for testing)
- Maven (for project management)

## Prerequisites

- Java 11 or higher
- Maven
- An IDE (like IntelliJ IDEA or Eclipse)

## Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Bharani240296/weather-app.git
   cd weather-app
Build the Project

Navigate to the project directory and run:

bash

mvn clean install

Run the Application

You can run the application using the following command:

bash

mvn spring-boot:run

Alternatively, you can run the generated JAR file located in the target directory:

bash

java -jar target/weather-app-0.0.1-SNAPSHOT.jar

Access the API

Once the application is running, you can access the weather information by sending a GET request to:

bash

    http://localhost:8080/weather?city={city-name}

    Replace {city-name} with the name of the city you want to fetch weather information for.

Example Request

To get the weather for London, you can use the following curl command:

bash

curl -X GET "http://localhost:8080/weather?city=London"

Error Handling

The API will return appropriate error messages for the following scenarios:

    City parameter is required: If no city parameter is provided or if it's empty.
    City not found: If the specified city does not exist in the external weather service.
    Internal Server Error: For any unexpected errors.

Running Tests

You can run the test suite using Maven:

bash

mvn test

License

This project is licensed under the MIT License - see the LICENSE file for details.
Contributing

Contributions are welcome! Please submit a pull request or open an issue for any suggestions or improvements.
Contact

For questions or inquiries, feel free to reach out at bharani240296@gmail.com.

css


### Instructions to Customize
- Replace `Bharani2402296` in the clone URL with your actual GitHub username.
- Update the `email` in the Contact section with your actual email.
- Add any additional features or setup steps specific to your project as needed.
- You might also want to add a section for API documentation if your project grows in complexity.

### How to Use
Just copy and paste the above content into a file named `README.md` in the root of your project