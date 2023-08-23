package swa.hotel.api;

import lombok.Data;

@Data
public class GetBookingsRequest {

    private String customerId;
    private String roomId;

}
