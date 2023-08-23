package swa.hotel.service.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import swa.hotel.api.CreateRoomReviewRequest;
import swa.hotel.api.GetRoomReviewRequest;
import swa.hotel.api.GetRoomReviewsRequest;
import swa.hotel.model.RoomReview;
import swa.hotel.service.integration.hotel.api.GetBookingsResponse;
import swa.hotel.service.integration.hotel.api.GetRoomResponse;

import java.util.List;
import java.util.Optional;

@Component
public class RoomReviewValidator extends AbstractValidator {

    private static final String CUSTOMER_NOT_VISIT_ROOM_MSG = "Customer not visited the room.";
    private static final String NO_ROOM_WITH_ID = "Room with ID was not found";
    private static final String NO_REVIEWS = "Reviews was not found.";
    private static final String FIELD_MISSING_CREATE_ROOM_REVIEW_REQUEST = "CreateRoomReviewRequest";
    private static final String FIELD_MISSING_GET_ROOM_REVIEW_REQUEST = "GetRoomReviewRequest";
    private static final String FIELD_MISSING_GET_ROOM_REVIEWS_REQUEST = "GetRoomReviewsRequest";
    private static final String FIELD_MISSING_CUSTOMER_ID = "customerId";
    private static final String FIELD_MISSING_ROOM_ID = "roomId";
    private static final String FIELD_MISSING_REVIEW_ID = "roomId";

    public void validateCustomerVisitRoom(GetBookingsResponse getBookingsResponse) {

        if (getBookingsResponse == null
                || CollectionUtils.isEmpty(getBookingsResponse.getBookings())) {

            notFound(CUSTOMER_NOT_VISIT_ROOM_MSG);
        }
    }

    public void validateGetRoomReviewRequest(GetRoomReviewRequest request) {

        if (request == null) {

            field_missing(FIELD_MISSING_GET_ROOM_REVIEW_REQUEST);
            return;
        }

        if (StringUtils.isBlank(request.getId())) {

            field_missing(FIELD_MISSING_REVIEW_ID);
        }
    }

    public void validateGetRoomReviewsRequest(GetRoomReviewsRequest request) {

        if (request == null) {

            field_missing(FIELD_MISSING_GET_ROOM_REVIEWS_REQUEST);
            return;
        }

        if (StringUtils.isBlank(request.getRoomId())) {

            field_missing(FIELD_MISSING_ROOM_ID);
        }
    }

    public void validateCreateRoomReviewRequest(CreateRoomReviewRequest request) {

        if (request == null
                || request.getRoomReview() == null) {

            field_missing(FIELD_MISSING_CREATE_ROOM_REVIEW_REQUEST);
            return;
        }

        var review = request.getRoomReview();

        if (review.getCustomerId() == null) {

            field_missing(FIELD_MISSING_CUSTOMER_ID);
            return;
        }

        if (review.getRoomId() == null) {

            field_missing(FIELD_MISSING_ROOM_ID);
        }
    }

    public void validateRoom(GetRoomResponse room) {

        if (room == null) {

            notFound(NO_ROOM_WITH_ID);
        }
    }

    public void validateRoomReviews(List<RoomReview> roomReviews) {

        if (CollectionUtils.isEmpty(roomReviews)) {

            notFound(NO_REVIEWS);
        }
    }

    public void validateRoomReviews(Optional<RoomReview> roomReview) {

        if (roomReview.isEmpty()) {

            notFound(NO_REVIEWS);
        }
    }

}
