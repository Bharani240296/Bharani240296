package com.weatherApp.service;

import com.weatherApp.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class WeatherService {

    private final String API_KEY = "1ba21ebbbcc4ad76537f9c7c172b123d";
    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public WeatherResponse getWeather(String city) {
        String url = String.format(API_URL, city, API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // Parse the JSON response
        JSONObject json = new JSONObject(response);
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCityName(json.getString("name"));
        weatherResponse.setTemperature(json.getJSONObject("main").getDouble("temp"));
        weatherResponse.setHumidity(json.getJSONObject("main").getInt("humidity"));
        weatherResponse.setWeatherDescription(json.getJSONArray("weather").getJSONObject(0).getString("description"));
        weatherResponse.setWindSpeed(json.getJSONObject("wind").getDouble("speed"));

        return weatherResponse;
    }
}

