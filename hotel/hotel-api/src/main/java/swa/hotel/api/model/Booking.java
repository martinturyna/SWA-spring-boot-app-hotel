package swa.hotel.api.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Booking {

    private String id;
    private String roomId;
    private String hotelId;

    private LocalDate from;
    private LocalDate to;

}
