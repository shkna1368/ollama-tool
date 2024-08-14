package com.example.ollama;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;
@Component
public  class MockFlight
        implements Function<MockFlight.FlightRequest, MockFlight.FlightResponse> {

    public record FlightRequest(String destination, Date date) {
    }

    public record FlightResponse(double price,String message) {
    }

    @Override
    public MockFlight.FlightResponse apply(MockFlight.FlightRequest request) {
        long price = request.destination().contains("Kurdistan") ? 6000 : 8000;
        return new MockFlight.FlightResponse(price, request.destination);
    }
}
