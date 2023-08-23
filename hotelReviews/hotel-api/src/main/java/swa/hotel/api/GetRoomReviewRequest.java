package swa.hotel.api;

import lombok.Data;

@Data
public class GetRoomReviewRequest {

    private String id;
    private String customerId;
    private String roomId;

}
