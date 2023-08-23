package swa.hotel.service.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import swa.hotel.api.model.Hotel;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HotelMapper {

    private final RoomMapper roomMapper;

    @Nullable
    public Hotel mapToHotel(swa.hotel.model.Hotel dbHotel) {

        if (dbHotel == null) {

            return null;
        }

        var hotel = new Hotel();
        hotel.setName(dbHotel.getName());
        hotel.setId(dbHotel.getId().toString());

        if (CollectionUtils.isNotEmpty(dbHotel.getRooms())) {

            var rooms = dbHotel.getRooms().stream()
                    .map(roomMapper::mapToRoom)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            hotel.setRooms(rooms);
        }

        return hotel;
    }

}
