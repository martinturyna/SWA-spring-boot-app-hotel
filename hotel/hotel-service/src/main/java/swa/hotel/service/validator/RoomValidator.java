package swa.hotel.service.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import swa.hotel.model.Room;

import java.util.List;
import java.util.Optional;

@Component
public class RoomValidator extends AbstractValidator {

    private static final String NO_ROOM_FOUND = "Room(s) was not found";

    public void validateRooms(List<Room> rooms) {

        if(CollectionUtils.isEmpty(rooms)) {

            notFound(NO_ROOM_FOUND);
        }
    }

    public void validateRoom(Optional<Room> room) {

        if(room.isEmpty()) {
            notFound(NO_ROOM_FOUND);
        }
    }

}
