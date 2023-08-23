package swa.hotel.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swa.hotel.api.GetRoomRequest;
import swa.hotel.api.GetRoomResponse;
import swa.hotel.api.GetRoomsResponse;
import swa.hotel.service.RoomService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/rooms")
@RequiredArgsConstructor
public class RoomResource {

    private final RoomService roomService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public GetRoomsResponse getRooms() {

        return roomService.getRooms();
    }

    @GetMapping(value = "/{id}",
    produces = APPLICATION_JSON_VALUE)
    public GetRoomResponse getRoom(@PathVariable String id) {

        var request = new GetRoomRequest();
        request.setId(id);

        return roomService.getRoom(request);
    }

}
