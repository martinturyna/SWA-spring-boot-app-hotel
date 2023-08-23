package swa.hotel.api;

import lombok.Data;
import swa.hotel.api.model.Booking;

import java.util.List;

@Data
public class GetBookingsResponse {

    private List<Booking> bookings;

}
