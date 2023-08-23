package swa.hotel.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swa.hotel.api.model.Hotel;
import swa.hotel.api.model.Room;
import swa.hotel.service.integration.hotel.api.model.Booking;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderMapperTest {

    private static final LocalDate FROM_TEST = LocalDate.now().minusDays(2L);
    private static final LocalDate TO_TEST = LocalDate.now().plusDays(2L);

    private static final String BOOKING_ROOM_ID_TEST = "1000";

    private OrderMapper mapper;

    @BeforeEach
    void setup() {

        mapper = new OrderMapper();
    }

    @Test
    void mapBookingToOrderTest() {

        var booking = mockBooking();
        var hotel = new Hotel();
        var rooms = new ArrayList<Room>();


        var order = mapper.mapBookingToOrder(booking, hotel);

        assertNotNull(order);
        assertEquals(order.getFrom(), FROM_TEST);
        assertEquals(order.getTo(), TO_TEST);
        assertEquals(hotel, order.getHotel());
        assertNull(order.getRoom());

        //add room no matching id
        rooms.add(mockRoom("1001"));
        hotel.setRooms(rooms);
        order = mapper.mapBookingToOrder(booking, hotel);

        assertNotNull(order);
        assertEquals(order.getFrom(), FROM_TEST);
        assertEquals(order.getTo(), TO_TEST);
        assertEquals(hotel, order.getHotel());
        assertNull(order.getRoom());

        //add room with matching id
        rooms.add(mockRoom(BOOKING_ROOM_ID_TEST));
        hotel.setRooms(rooms);
        order = mapper.mapBookingToOrder(booking, hotel);

        assertNotNull(order);
        assertEquals(order.getFrom(), FROM_TEST);
        assertEquals(order.getTo(), TO_TEST);
        assertEquals(hotel, order.getHotel());
        assertNotNull(order.getRoom());

    }

    private Booking mockBooking() {

        var booking = new Booking();
        booking.setFrom(FROM_TEST);
        booking.setTo(TO_TEST);
        booking.setRoomId(BOOKING_ROOM_ID_TEST);

        return booking;
    }

    private Room mockRoom(String roomId) {

        var room = new Room();
        room.setRoomId(roomId);

        return room;
    }

}
