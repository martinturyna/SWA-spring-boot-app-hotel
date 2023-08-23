package swa.hotel.service.integration.hotel.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import swa.hotel.service.integration.hotel.api.GetBookingsResponse;
import swa.hotel.service.integration.hotel.api.GetHotelResponse;
import swa.hotel.service.integration.hotel.connector.HotelConnector;

import static swa.hotel.service.integration.hotel.config.HotelConstants.CIRCUIT_GET_BOOKINGS;
import static swa.hotel.service.integration.hotel.config.HotelConstants.CIRCUIT_GET_HOTEL;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelConnector hotelConnector;

    @Nullable
    @CircuitBreaker(name = CIRCUIT_GET_BOOKINGS)
    public GetBookingsResponse getBookings(String customerId) {

        return hotelConnector.getBookings(customerId);
    }

    @Nullable
    @CircuitBreaker(name = CIRCUIT_GET_HOTEL)
    public GetHotelResponse getHotel(String hotelId) {

        return hotelConnector.getHotel(hotelId);
    }

}
