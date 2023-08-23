package swa.hotel.api;

import lombok.Data;

@Data
public class GetHotelRoomRequest {

    private String hotelId;
    private String roomNumber;

}
