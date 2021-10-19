package com.example.hiringtest.service;

import com.example.hiringtest.model.Weather;
import com.example.hiringtest.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    public Weather createWeather(Weather weather) {
        weatherRepository.save(weather);
        return weather;
    }

    public List<Weather> getWeather(String date) throws ParseException {
        if (date!=null){
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return weatherRepository.findAllByDate(date1);
        }
        return weatherRepository.findAll();
    }
}
