package swa.hotel.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swa.hotel.model.Hotel;

import static org.junit.jupiter.api.Assertions.*;

public class HotelMapperTest {

    private static final String NAME_TEST = "NAME";

    private static final Long ID_TEST = 100L;

    private HotelMapper mapper;

    @BeforeEach
    void setup() {

        mapper = new HotelMapper(new RoomMapper());
    }

    @Test
    void mapToHotelTest() {

        var hotel = mapper.mapToHotel(mockDbHotel());

        assertNotNull(hotel);
        assertEquals(NAME_TEST, hotel.getName());
        assertEquals(ID_TEST.toString(), hotel.getId());
        assertNull(hotel.getRooms());

        hotel = mapper.mapToHotel(null);
        assertNull(hotel);
    }

    private Hotel mockDbHotel() {

        var hotel = new Hotel();
        hotel.setId(ID_TEST);
        hotel.setName(NAME_TEST);
        hotel.setRooms(null);

        return hotel;
    }

}
