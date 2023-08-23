package swa.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import swa.hotel.api.*;
import swa.hotel.repository.RoomReviewRepository;
import swa.hotel.service.async.AsyncCaller;
import swa.hotel.service.mapper.RoomReviewMapper;
import swa.hotel.service.validator.RoomReviewValidator;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomReviewService {

    private final AsyncCaller asyncCaller;

    private final RoomReviewRepository roomReviewRepository;

    private final RoomReviewValidator roomReviewValidator;

    private final RoomReviewMapper roomReviewMapper;

    public GetRoomReviewsResponse getRoomReviews() {

        var dbReviews = roomReviewRepository.findAll();
        roomReviewValidator.validateRoomReviews(dbReviews);

        var reviews = dbReviews.stream()
                .map(roomReviewMapper::mapToRoomReview)
                .collect(Collectors.toList());

        var response = new GetRoomReviewsResponse();
        response.setRoomReviews(reviews);

        return response;
    }

    public GetRoomReviewResponse getRoomReview(GetRoomReviewRequest request) {

        roomReviewValidator.validateGetRoomReviewRequest(request);

        var dbRoomReview = roomReviewRepository.findById(Long.valueOf(request.getId()));
        roomReviewValidator.validateRoomReviews(dbRoomReview);

        var response = new GetRoomReviewResponse();
        response.setRoomReview(roomReviewMapper.mapToRoomReview(dbRoomReview.get()));

        return response;
    }

    public GetRoomReviewsResponse getRoomReviewByRoom(GetRoomReviewsRequest request) {

        roomReviewValidator.validateGetRoomReviewsRequest(request);
        var room = asyncCaller.getRoom(request.getRoomId()).join();

        roomReviewValidator.validateRoom(room);

        var dbRoomReviews = roomReviewRepository.findByRoomId(Long.valueOf(request.getRoomId()));
        roomReviewValidator.validateRoomReviews(dbRoomReviews);

        var response = new GetRoomReviewsResponse();
        response.setRoomReviews(dbRoomReviews.stream().map(roomReviewMapper::mapToRoomReview).collect(Collectors.toList()));

        return response;
    }

    public void createRoomReview(CreateRoomReviewRequest request) {

        var review = request.getRoomReview();
        roomReviewValidator.validateCreateRoomReviewRequest(request);

        var bookings = asyncCaller.getBookings(review.getCustomerId().toString(), review.getRoomId().toString()).join();
        roomReviewValidator.validateCustomerVisitRoom(bookings);

        var dbRoomReview = roomReviewMapper.mapToDbRoomReview(review);
        roomReviewRepository.save(dbRoomReview);
    }

}
