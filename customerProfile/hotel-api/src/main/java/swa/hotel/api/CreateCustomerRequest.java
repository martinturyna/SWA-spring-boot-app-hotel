package swa.hotel.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import swa.hotel.api.model.Customer;

@Data
public class CreateCustomerRequest {

    @JsonUnwrapped
    private Customer customer;

}
