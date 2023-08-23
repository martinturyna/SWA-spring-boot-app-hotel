package swa.hotel.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swa.hotel.api.model.RoomReview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoomReviewMapperTest {

    private static final Long ROOM_ID_TEST = 1000L;
    private static final Long CUSTOMER_ID_TEST = 1005L;
    private static final Long RATING_TEST = 5L;

    private static final String DESCRIPTION_TEST = "Description";

    private RoomReviewMapper mapper;

    @BeforeEach
    void setup() {

        mapper = new RoomReviewMapper();
    }

    @Test
    void mapToRoomReviewTest() {

        var roomReview = mapper.mapToRoomReview(mockDbRoomReview());

        assertNotNull(roomReview);
        assertEquals(ROOM_ID_TEST, roomReview.getRoomId());
        assertEquals(CUSTOMER_ID_TEST, roomReview.getCustomerId());
        assertEquals(RATING_TEST, roomReview.getRating());
        assertEquals(DESCRIPTION_TEST, roomReview.getDescription());
    }

    @Test
    void mapToDbRoomReviewTest() {

        var dbRoomReview = mapper.mapToDbRoomReview(mockRoomReview());

        assertNotNull(dbRoomReview);
        assertEquals(ROOM_ID_TEST, dbRoomReview.getRoomId());
        assertEquals(CUSTOMER_ID_TEST, dbRoomReview.getCustomerId());
        assertEquals(RATING_TEST, dbRoomReview.getRating());
        assertEquals(DESCRIPTION_TEST, dbRoomReview.getDescription());
    }

    private swa.hotel.model.RoomReview mockDbRoomReview() {

        var dbRoomReview = new swa.hotel.model.RoomReview();
        dbRoomReview.setRoomId(ROOM_ID_TEST);
        dbRoomReview.setCustomerId(CUSTOMER_ID_TEST);
        dbRoomReview.setRating(RATING_TEST);
        dbRoomReview.setDescription(DESCRIPTION_TEST);

        return dbRoomReview;
    }

    private RoomReview mockRoomReview() {

        var roomReview = new RoomReview();
        roomReview.setRoomId(ROOM_ID_TEST);
        roomReview.setCustomerId(CUSTOMER_ID_TEST);
        roomReview.setRating(RATING_TEST);
        roomReview.setDescription(DESCRIPTION_TEST);

        return roomReview;
    }

}
