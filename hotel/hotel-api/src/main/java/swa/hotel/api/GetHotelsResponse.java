package swa.hotel.api;

import lombok.Data;
import swa.hotel.api.model.Hotel;

import java.util.List;

@Data
public class GetHotelsResponse {

    private List<Hotel> hotels;

}
