package swa.hotel.service.utils;

import lombok.NoArgsConstructor;
import swa.hotel.model.Room;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class BookingUtils {

    public static List<Room> filterOccupiedRooms(List<Room> rooms,
                                                 Set<Long> occupiedRooms) {

        return rooms.stream()
                .filter(room -> !occupiedRooms.contains(room.getId()))
                .collect(Collectors.toList());
    }

}
