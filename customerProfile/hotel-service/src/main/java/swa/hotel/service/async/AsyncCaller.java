package swa.hotel.service.async;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import swa.hotel.service.integration.hotel.api.GetBookingsResponse;
import swa.hotel.service.integration.hotel.api.GetHotelResponse;
import swa.hotel.service.integration.hotel.service.HotelService;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncCaller {

    private final HotelService hotelService;

    @Async
    public CompletableFuture<GetBookingsResponse> getBookings(String id) {

        return CompletableFuture.completedFuture(hotelService.getBookings(id));
    }

    @Async
    public CompletableFuture<GetHotelResponse> getHotel(String id) {

        return CompletableFuture.completedFuture(hotelService.getHotel(id));
    }

}
