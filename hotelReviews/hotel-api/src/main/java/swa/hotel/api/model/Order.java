package swa.hotel.api.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {

    private LocalDate from;
    private LocalDate to;

    private Hotel hotel;

    private Room room;

}
