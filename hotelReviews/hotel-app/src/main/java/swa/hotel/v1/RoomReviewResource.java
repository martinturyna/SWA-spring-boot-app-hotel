package swa.hotel.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import swa.hotel.api.*;
import swa.hotel.service.RoomReviewService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/room-reviews")
@RequiredArgsConstructor
public class RoomReviewResource {

    private final RoomReviewService roomReviewService;

    @GetMapping
    public GetRoomReviewsResponse getRoomReviews() {

        return roomReviewService.getRoomReviews();
    }

    @GetMapping(value = "/{id}",
            produces = APPLICATION_JSON_VALUE)
    public GetRoomReviewResponse getRoomReview(@PathVariable String id) {

        var request = new GetRoomReviewRequest();
        request.setId(id);

        return roomReviewService.getRoomReview(request);
    }

    @GetMapping(value = "/room/{roomId}",
            produces = APPLICATION_JSON_VALUE)
    public GetRoomReviewsResponse getRoomReviewsByRoom(@PathVariable String roomId) {

        var request = new GetRoomReviewsRequest();
        request.setRoomId(roomId);

        return roomReviewService.getRoomReviewByRoom(request);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createRoomReview(@RequestBody CreateRoomReviewRequest request) {

        roomReviewService.createRoomReview(request);
    }

}
