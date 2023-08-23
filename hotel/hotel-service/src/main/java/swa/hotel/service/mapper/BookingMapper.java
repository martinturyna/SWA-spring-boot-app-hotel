package swa.hotel.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swa.hotel.api.model.Booking;
import swa.hotel.model.RoomAvailability;

@Component
@RequiredArgsConstructor
public class BookingMapper {

    public Booking mapToBooking(RoomAvailability roomAvailability) {

        var booking = new Booking();
        booking.setFrom(roomAvailability.getDateFrom());
        booking.setTo(roomAvailability.getDateTo());
        booking.setId(roomAvailability.getId().toString());
        booking.setRoomId(roomAvailability.getRoomId().toString());
        booking.setHotelId(roomAvailability.getHotelId().toString());

        return booking;
    }

}
