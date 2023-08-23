package swa.hotel.service.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import swa.hotel.api.model.Hotel;
import swa.hotel.api.model.Order;
import swa.hotel.service.integration.hotel.api.model.Booking;

@Component
public class OrderMapper {

    public Order mapBookingToOrder(Booking booking,
                                   Hotel hotel) {

        var order = new Order();
        order.setFrom(booking.getFrom());
        order.setTo(booking.getTo());

        order.setHotel(hotel);

        if (CollectionUtils.isNotEmpty(hotel.getRooms())) {

            var foundRoom = hotel.getRooms().stream()
                    .filter(room -> StringUtils.equals(room.getRoomId(), booking.getRoomId()))
                    .findFirst()
                    .orElse(null);

            order.setRoom(foundRoom);
        }

        hotel.setRooms(null);

        return order;
    }

}
