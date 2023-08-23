package swa.hotel.api;

import lombok.Data;
import swa.hotel.api.model.Room;

import java.util.List;

@Data
public class GetAvailableRoomsResponse {

    private List<Room> rooms;

}
