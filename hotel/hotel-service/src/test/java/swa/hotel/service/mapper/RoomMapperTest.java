package swa.hotel.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swa.hotel.api.model.Room;

import static org.junit.jupiter.api.Assertions.*;

public class RoomMapperTest {

    private static final int ROOM_NUMBER_TEST = 101;
    private static final int BED_COUNT_TEST = 2;
    private static final int FLOOR_TEST = 1;

    private static final Long ROOM_ID_TEST = 1234L;

    private RoomMapper mapper;

    @BeforeEach
    void setup() {

        mapper = new RoomMapper();
    }

    @Test
    void mapToRoomTest() {

        var room = mapper.mapToRoom(mockDbRoom());

        assertNotNull(room);
        assertEquals(ROOM_NUMBER_TEST, room.getRoomNumber());
        assertEquals(BED_COUNT_TEST, room.getBedCount());
        assertEquals(FLOOR_TEST, room.getFloor());
        assertEquals(ROOM_ID_TEST.toString(), room.getRoomId());

        room = mapper.mapToRoom(null);
        assertNull(room);
    }

    @Test
    void mapToDbRoomTest() {

        var dbRoom = mapper.mapToDbRoom(mockRoom(), null);

        assertNotNull(dbRoom);
        assertEquals(ROOM_NUMBER_TEST, dbRoom.getRoomNumber());
        assertEquals(BED_COUNT_TEST, dbRoom.getBedCount());
        assertEquals(FLOOR_TEST, dbRoom.getFloor());
        assertNull(dbRoom.getId());
    }

    private Room mockRoom() {

        var room = new Room();
        room.setRoomId(ROOM_ID_TEST.toString());
        room.setRoomNumber(ROOM_NUMBER_TEST);
        room.setBedCount(BED_COUNT_TEST);
        room.setFloor(FLOOR_TEST);

        return room;
    }

    private swa.hotel.model.Room mockDbRoom() {

        var dbRoom = new swa.hotel.model.Room();
        dbRoom.setId(ROOM_ID_TEST);
        dbRoom.setRoomNumber(ROOM_NUMBER_TEST);
        dbRoom.setBedCount(BED_COUNT_TEST);
        dbRoom.setFloor(FLOOR_TEST);

        return dbRoom;
    }

}
