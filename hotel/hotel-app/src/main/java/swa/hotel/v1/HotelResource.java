package swa.hotel.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import swa.hotel.api.*;
import swa.hotel.service.HotelService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/hotels")
@RequiredArgsConstructor
public class HotelResource {

    private final HotelService hotelService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public GetHotelsResponse getHotels() {

        return hotelService.getHotels();
    }

    @GetMapping(value = "/{id}",
            produces = APPLICATION_JSON_VALUE)
    public GetHotelResponse getHotel(@PathVariable String id) {

        var request = new GetHotelRequest();
        request.setId(id);

        return hotelService.getHotel(request);
    }

    @PostMapping(value = "/{hotelId}/room",
            consumes = APPLICATION_JSON_VALUE)
    public void createRoom(@PathVariable String hotelId,
                           @RequestBody CreateRoomRequest request) {

        request.setHotelId(hotelId);

        hotelService.createRoom(request);
    }

    @GetMapping(value = "/{hotelId}/room/{roomNumber}",
            produces = APPLICATION_JSON_VALUE)
    public GetHotelRoomResponse getRoom(@PathVariable String hotelId,
                                        @PathVariable String roomNumber) {

        var request = new GetHotelRoomRequest();
        request.setHotelId(hotelId);
        request.setRoomNumber(roomNumber);

        return hotelService.getRoom(request);
    }

}
