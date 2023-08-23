package swa.hotel.api;

import lombok.Data;
import swa.hotel.api.model.RoomReview;

import java.util.List;

@Data
public class GetRoomReviewsResponse {

    private List<RoomReview> roomReviews;

}
