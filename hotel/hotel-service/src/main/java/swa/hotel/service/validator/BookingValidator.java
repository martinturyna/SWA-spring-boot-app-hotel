package swa.hotel.service.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import swa.hotel.model.RoomAvailability;

import java.util.List;

@Component
public class BookingValidator extends AbstractValidator {

    private static final String NO_BOOKING_FOUND = "No booking(s) found";

    public void validateBookings(List<RoomAvailability> bookings) {

        if (CollectionUtils.isEmpty(bookings)) {

            notFound(NO_BOOKING_FOUND);
        }
    }

}
