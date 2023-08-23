package swa.hotel.api.model;

import lombok.Data;

import java.util.List;

@Data
public class Hotel {

    private String name;

    private List<Room> rooms;

}
