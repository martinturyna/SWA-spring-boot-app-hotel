package swa.hotel.service.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import swa.hotel.api.model.Room;
import swa.hotel.model.Hotel;

import java.util.List;
import java.util.Optional;

@Component
public class HotelValidator extends AbstractValidator {

    private static final String NO_HOTEL_FOUND = "Hotel(s) was not found";
    private static final String NO_HOTEL_ROOM_FOUND = "Hotel room was not found";

    public void validateHotels(List<Hotel> hotels) {

        if (CollectionUtils.isEmpty(hotels)) {

            notFound(NO_HOTEL_FOUND);
        }
    }

    public void validateHotel(Optional<Hotel> hotel) {

        if (hotel.isEmpty()) {

            notFound(NO_HOTEL_FOUND);
        }
    }

    public void validateHotelRoom(Room room) {

        if(room == null) {

            notFound(NO_HOTEL_ROOM_FOUND);
        }
    }

    public void validateHotelRoom(swa.hotel.model.Room room) {

        if(room == null) {

            notFound(NO_HOTEL_ROOM_FOUND);
        }
    }

}
