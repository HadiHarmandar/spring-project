package com.cydeo.client;

import com.cydeo.dto.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com/current", name = "WEATHER-CLIENT")
public interface WeatherClient {

    @GetMapping("/current")
    Weather getWeather(@RequestParam(value = "query") String city, @RequestParam(value = "access_key") String accessKey);

}
