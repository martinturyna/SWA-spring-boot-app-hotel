package swa.hotel.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import swa.hotel.api.model.RoomReview;

@Data
public class CreateRoomReviewRequest {

    @JsonUnwrapped
    private RoomReview roomReview;

}
