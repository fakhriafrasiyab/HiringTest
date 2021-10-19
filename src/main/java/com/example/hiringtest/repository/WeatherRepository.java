package com.example.hiringtest.repository;

import com.example.hiringtest.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> findAllByDate(Date date);
}
