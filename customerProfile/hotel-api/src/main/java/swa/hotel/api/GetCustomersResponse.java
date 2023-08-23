package swa.hotel.api;

import lombok.Data;
import swa.hotel.api.model.Customer;

import java.util.List;

@Data
public class GetCustomersResponse {

    private List<Customer> customers;

}
