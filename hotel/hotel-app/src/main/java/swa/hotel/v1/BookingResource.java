package swa.hotel.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import swa.hotel.api.GetAvailableRoomsRequest;
import swa.hotel.api.GetAvailableRoomsResponse;
import swa.hotel.api.GetBookingsRequest;
import swa.hotel.api.GetBookingsResponse;
import swa.hotel.service.BookingService;

import java.time.LocalDate;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/bookings")
@RequiredArgsConstructor
public class BookingResource {

    private final BookingService bookingService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public GetBookingsResponse getBookings(@RequestParam(name = "customerId" , required = false) String customerId,
                                           @RequestParam(name = "roomId", required = false) String roomId) {

        var request = new GetBookingsRequest();
        request.setCustomerId(customerId);
        request.setRoomId(roomId);

        return bookingService.getBookings(request);
    }

    @GetMapping(value = "/hotel/{hotelId}/available-rooms",
            produces = APPLICATION_JSON_VALUE)
    public GetAvailableRoomsResponse getAvailableRooms(@PathVariable String hotelId,
                                                       @RequestParam(name = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                       @RequestParam(name = "to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

        var request = new GetAvailableRoomsRequest();
        request.setHotelId(hotelId);
        request.setFrom(from);
        request.setTo(to);

        return bookingService.getAvailableRooms(request);
    }

}
