package swa.hotel.api;

import lombok.Data;
import swa.hotel.api.model.Order;

import java.util.List;

@Data
public class GetCustomerOrdersResponse {

    private List<Order> orders;

}
