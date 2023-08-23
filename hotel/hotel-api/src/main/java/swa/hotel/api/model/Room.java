package swa.hotel.api.model;

import lombok.Data;

@Data
public class Room {

    private String roomId;

    private int roomNumber;
    private int floor;
    private int bedCount;

}
