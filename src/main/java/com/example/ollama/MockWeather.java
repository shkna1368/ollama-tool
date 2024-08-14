package com.example.ollama;

import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public  class MockWeather
        implements Function<MockWeather.WeatherRequest, MockWeather.WeatherResponse> {

    public record WeatherRequest(String location, String unit) {
    }

    public record WeatherResponse(double temp, String unit) {
    }

    @Override
    public MockWeather.WeatherResponse apply(MockWeather.WeatherRequest request) {
        double temperature = request.location().contains("Amsterdam") ? 20 : 25;
        return new MockWeather.WeatherResponse(temperature, request.unit);
    }
}
