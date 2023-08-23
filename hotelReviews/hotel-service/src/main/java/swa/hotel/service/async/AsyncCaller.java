package swa.hotel.service.async;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import swa.hotel.service.integration.hotel.api.GetBookingsResponse;
import swa.hotel.service.integration.hotel.api.GetRoomResponse;
import swa.hotel.service.integration.hotel.service.HotelService;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncCaller {

    private final HotelService hotelService;

    @Async
    public CompletableFuture<GetRoomResponse> getRoom(String roomId) {

        return CompletableFuture.completedFuture(hotelService.getRoom(roomId));
    }

    @Async
    public CompletableFuture<GetBookingsResponse> getBookings(String customerId,
                                                              String roomId) {

        return CompletableFuture.completedFuture(hotelService.getBookings(customerId, roomId));
    }

}
