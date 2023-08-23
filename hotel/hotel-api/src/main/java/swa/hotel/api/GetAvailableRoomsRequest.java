package swa.hotel.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAvailableRoomsRequest {

    private String hotelId;

    private LocalDate from;
    private LocalDate to;

}
