package swa.hotel.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import swa.hotel.api.GetAvailableRoomsRequest;
import swa.hotel.api.GetAvailableRoomsResponse;
import swa.hotel.api.GetBookingsRequest;
import swa.hotel.api.GetBookingsResponse;
import swa.hotel.model.RoomAvailability;
import swa.hotel.repository.HotelRepository;
import swa.hotel.repository.RoomAvailabilityRepository;
import swa.hotel.service.mapper.BookingMapper;
import swa.hotel.service.mapper.RoomMapper;
import swa.hotel.service.validator.BookingValidator;
import swa.hotel.service.validator.HotelValidator;

import java.util.List;
import java.util.stream.Collectors;

import static swa.hotel.service.utils.BookingUtils.filterOccupiedRooms;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final RoomAvailabilityRepository roomAvailabilityRepository;

    private final HotelRepository hotelRepository;

    private final BookingMapper bookingMapper;

    private final RoomMapper roomMapper;

    private final BookingValidator bookingValidator;

    private final HotelValidator hotelValidator;

    public GetBookingsResponse getBookings(GetBookingsRequest request) {

        var dbBookings = StringUtils.isNotEmpty(request.getCustomerId()) || StringUtils.isNotEmpty(request.getRoomId())
                ? getFilteredBookings(request)
                : roomAvailabilityRepository.findAll();

        bookingValidator.validateBookings(dbBookings);

        var bookings = dbBookings.stream()
                .map(bookingMapper::mapToBooking)
                .collect(Collectors.toList());

        var response = new GetBookingsResponse();
        response.setBookings(bookings);

        return response;
    }

    public GetAvailableRoomsResponse getAvailableRooms(GetAvailableRoomsRequest request) {

        var dbHotel = hotelRepository.findById(Long.valueOf(request.getHotelId()));
        hotelValidator.validateHotel(dbHotel);

        var response = new GetAvailableRoomsResponse();
        var occupiedRooms = roomAvailabilityRepository.findOccupiedRooms(dbHotel.get().getId(), request.getFrom(), request.getTo());

        var occupiedRoomIds = occupiedRooms.stream()
                .map(RoomAvailability::getRoomId)
                .collect(Collectors.toSet());
        var availableDbRooms = filterOccupiedRooms(dbHotel.get().getRooms(), occupiedRoomIds);

        response.setRooms(availableDbRooms.stream()
                .map(roomMapper::mapToRoom)
                .collect(Collectors.toList()));

        return response;
    }

    private List<RoomAvailability> getFilteredBookings(GetBookingsRequest request) {

        if (StringUtils.isNotBlank(request.getRoomId())
                && StringUtils.isNotBlank(request.getCustomerId())) {

            return roomAvailabilityRepository.findUserRoomBookings(Long.valueOf(request.getCustomerId()), Long.valueOf(request.getRoomId()));
        } else if (StringUtils.isNotBlank(request.getRoomId())) {

            return roomAvailabilityRepository.findAllByRoomId(Long.valueOf(request.getRoomId()));
        }

        return roomAvailabilityRepository.findAllByCustomerId(Long.valueOf(request.getCustomerId()));
    }

}
