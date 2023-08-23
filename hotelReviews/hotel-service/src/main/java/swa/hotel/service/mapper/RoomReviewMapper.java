package swa.hotel.service.mapper;

import org.springframework.stereotype.Component;
import swa.hotel.api.model.RoomReview;

@Component
public class RoomReviewMapper {

    public RoomReview mapToRoomReview(swa.hotel.model.RoomReview dbRoomReview) {

        var review = new RoomReview();
        review.setRoomId(dbRoomReview.getRoomId());
        review.setCustomerId(dbRoomReview.getCustomerId());
        review.setRating(dbRoomReview.getRating());
        review.setDescription(dbRoomReview.getDescription());

        return review;
    }

    public swa.hotel.model.RoomReview mapToDbRoomReview(RoomReview review) {

        var dbRoomReview = new swa.hotel.model.RoomReview();
        dbRoomReview.setRoomId(review.getRoomId());
        dbRoomReview.setCustomerId(review.getCustomerId());
        dbRoomReview.setRating(review.getRating());
        dbRoomReview.setDescription(review.getDescription());

        return dbRoomReview;
    }

}
