package com.weatherApp.controller;

import com.weatherApp.model.WeatherResponse;
import com.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) {
        try {
            WeatherResponse response = weatherService.getWeather(city);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleHttpClientError(HttpClientErrorException e) {
        return new ResponseEntity<>("City not found", HttpStatus.NOT_FOUND);
    }
}


