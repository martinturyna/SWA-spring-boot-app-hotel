package swa.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swa.hotel.api.*;
import swa.hotel.api.model.Room;
import swa.hotel.model.Hotel;
import swa.hotel.repository.HotelRepository;
import swa.hotel.repository.RoomRepository;
import swa.hotel.service.mapper.HotelMapper;
import swa.hotel.service.mapper.RoomMapper;
import swa.hotel.service.validator.HotelValidator;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    private final RoomRepository roomRepository;

    private final HotelMapper hotelMapper;

    private final RoomMapper roomMapper;

    private final HotelValidator hotelValidator;

    public GetHotelsResponse getHotels() {

        var dbHotels = hotelRepository.findAll();
        hotelValidator.validateHotels(dbHotels);

        var hotels = dbHotels.stream()
                .map(hotelMapper::mapToHotel)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        var response = new GetHotelsResponse();
        response.setHotels(hotels);
        return response;
    }

    public GetHotelResponse getHotel(GetHotelRequest request) {

        var dbHotel = hotelRepository.findById(Long.valueOf(request.getId()));
        hotelValidator.validateHotel(dbHotel);

        var response = new GetHotelResponse();
        response.setHotel(hotelMapper.mapToHotel(dbHotel.get()));

        return response;
    }

    public GetHotelRoomResponse getRoom(GetHotelRoomRequest request) {

        var dbHotel = hotelRepository.findById(Long.valueOf(request.getHotelId()));
        hotelValidator.validateHotel(dbHotel);

        var room = findRoomByNumber(dbHotel.get(), request.getRoomNumber());
        hotelValidator.validateHotelRoom(room);

        var response = new GetHotelRoomResponse();
        response.setRoom(room);

        return response;
    }

    public void createRoom(CreateRoomRequest request) {

        var dbHotel = hotelRepository.findById(Long.valueOf(request.getHotelId()));
        hotelValidator.validateHotel(dbHotel);

        var dbRoom = roomMapper.mapToDbRoom(request.getRoom(), dbHotel.get());
        roomRepository.save(dbRoom);
    }

    private Room findRoomByNumber(Hotel dbHotel, String roomNumber) {

        var roomNumberInt = Integer.parseInt(roomNumber);

        var foundRoom = dbHotel.getRooms().stream()
                .filter(dbRoom -> dbRoom != null && dbRoom.getRoomNumber() == roomNumberInt)
                .findFirst()
                .orElse(null);

        hotelValidator.validateHotelRoom(foundRoom);

        return roomMapper.mapToRoom(foundRoom);
    }

}
