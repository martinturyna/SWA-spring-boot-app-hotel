package swa.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swa.hotel.api.GetRoomRequest;
import swa.hotel.api.GetRoomResponse;
import swa.hotel.api.GetRoomsResponse;
import swa.hotel.repository.RoomRepository;
import swa.hotel.service.mapper.RoomMapper;
import swa.hotel.service.validator.RoomValidator;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    private final RoomValidator roomValidator;

    public GetRoomsResponse getRooms() {

        var dbRooms = roomRepository.findAll();
        roomValidator.validateRooms(dbRooms);

        var rooms = dbRooms.stream()
                .map(roomMapper::mapToRoom)
                .collect(Collectors.toList());

        var response = new GetRoomsResponse();
        response.setRooms(rooms);

        return response;
    }

    public GetRoomResponse getRoom(GetRoomRequest request) {

        var dbRoom = roomRepository.findById(Long.valueOf(request.getId()));
        roomValidator.validateRoom(dbRoom);

        var response = new GetRoomResponse();
        response.setRoom(roomMapper.mapToRoom(dbRoom.get()));

        return response;
    }

}
