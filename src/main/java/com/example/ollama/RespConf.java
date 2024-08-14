package com.example.ollama;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RespConf {
    @Bean
    @Description("Get the weather in location")
    public Function<MockWeather.WeatherRequest,MockWeather.WeatherResponse> weatherFunctionCustom() {
        return new MockWeather();
    }

      @Bean
    @Description("Reserve flight")
    public Function<MockFlight.FlightRequest,MockFlight.FlightResponse> reserveFlight() {
        return new MockFlight();
    }



}
