package swa.hotel.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import swa.hotel.api.model.Room;

@Data
public class CreateRoomRequest {

    private String hotelId;

    @JsonUnwrapped
    private Room room;

}
