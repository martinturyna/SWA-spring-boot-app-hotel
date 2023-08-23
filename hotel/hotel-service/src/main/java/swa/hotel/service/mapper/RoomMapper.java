package swa.hotel.service.mapper;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import swa.hotel.api.model.Room;
import swa.hotel.model.Hotel;

@Component
public class RoomMapper {

    @Nullable
    public Room mapToRoom(swa.hotel.model.Room dbRoom) {

        if (dbRoom == null) {

            return null;
        }

        var room = new Room();
        room.setRoomNumber(dbRoom.getRoomNumber());
        room.setBedCount(dbRoom.getBedCount());
        room.setFloor(dbRoom.getFloor());
        room.setRoomId(String.valueOf(dbRoom.getId()));

        return room;
    }

    public swa.hotel.model.Room mapToDbRoom(Room room,
                                            Hotel dbHotel) {

        var dbRoom = new swa.hotel.model.Room();
        dbRoom.setRoomNumber(room.getRoomNumber());
        dbRoom.setBedCount(room.getBedCount());
        dbRoom.setFloor(room.getFloor());
        dbRoom.setHotel(dbHotel);

        return dbRoom;
    }

}
