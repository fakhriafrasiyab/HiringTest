package com.example.hiringtest.controller;

import com.example.hiringtest.model.Weather;
import com.example.hiringtest.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
public class WeatherApiRestController {
    private final WeatherService weatherService;

    public WeatherApiRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping(value = "/createWeather", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Weather> createWeather(@RequestBody @Valid Weather weather) {
        return new ResponseEntity<Weather>(weatherService.createWeather(weather), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getWeather")
    public List<Weather> getWeather(
            @RequestParam(required = false, value = "date") String date) throws ParseException {
        return weatherService.getWeather(date);
    }
}
