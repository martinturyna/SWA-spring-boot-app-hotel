package swa.hotel.api.model;

import lombok.Data;

@Data
public class RoomReview {

    private Long rating;
    private Long customerId;
    private Long roomId;

    private String description;

}
