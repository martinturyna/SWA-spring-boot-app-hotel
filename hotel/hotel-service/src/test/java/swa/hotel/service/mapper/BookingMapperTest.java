package swa.hotel.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swa.hotel.model.RoomAvailability;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingMapperTest {

    private static final LocalDate FROM_TEST = LocalDate.now().minusDays(2L);
    private static final LocalDate TO_TEST = LocalDate.now().plusDays(2L);

    private static final Long ID_TEST = 100L;
    private static final Long ROOM_ID_TEST = 104L;
    private static final Long HOTEL_ID_TEST = 107L;

    private BookingMapper mapper;

    @BeforeEach
    void setup() {

        mapper = new BookingMapper();
    }

    @Test
    void mapToBookingTest() {

        var booking = mapper.mapToBooking(mockRoomAvailability());

        assertNotNull(booking);
        assertEquals(FROM_TEST, booking.getFrom());
        assertEquals(TO_TEST, booking.getTo());
        assertEquals(ID_TEST.toString(), booking.getId());
        assertEquals(ROOM_ID_TEST.toString(), booking.getRoomId());
        assertEquals(HOTEL_ID_TEST.toString(), booking.getHotelId());
    }

    private RoomAvailability mockRoomAvailability() {

        var roomAvailability = new RoomAvailability();
        roomAvailability.setDateFrom(FROM_TEST);
        roomAvailability.setDateTo(TO_TEST);
        roomAvailability.setId(ID_TEST);
        roomAvailability.setRoomId(ROOM_ID_TEST);
        roomAvailability.setHotelId(HOTEL_ID_TEST);

        return roomAvailability;
    }

}
