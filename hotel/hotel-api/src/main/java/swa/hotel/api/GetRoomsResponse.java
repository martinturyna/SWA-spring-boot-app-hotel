package swa.hotel.api;

import lombok.Data;
import swa.hotel.api.model.Room;

import java.util.List;

@Data
public class GetRoomsResponse {

    private List<Room> rooms;

}
