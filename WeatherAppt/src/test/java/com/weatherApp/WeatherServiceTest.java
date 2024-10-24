package com.weatherApp;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.weatherApp.model.WeatherResponse;
import com.weatherApp.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;
import org.json.JSONObject;

class WeatherServiceTest {

    @InjectMocks
    private WeatherService weatherService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeather_ValidCity() {
        // Mock response from the OpenWeatherMap API
        String jsonResponse = "{ \"name\": \"London\", \"main\": {\"temp\": 15.5, \"humidity\": 82}, " +
                "\"weather\": [{\"description\": \"light rain\"}], \"wind\": {\"speed\": 4.1} }";

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(jsonResponse);

        // Call service method
        WeatherResponse response = weatherService.getWeather("London");

        // Assert response
        assertNotNull(response);
        assertEquals("London", response.getCityName());
        assertEquals(17.45, response.getTemperature());
        assertEquals(70, response.getHumidity());
        assertEquals("clear sky", response.getWeatherDescription());
        assertEquals(3.6, response.getWindSpeed());
    }

    @Test
    public void testGetWeather_InvalidCity() {
        // Simulate an error when the city is invalid
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Call service method and assert exception
        assertThrows(HttpClientErrorException.class, () -> weatherService.getWeather("InvalidCity"));
    }
}

