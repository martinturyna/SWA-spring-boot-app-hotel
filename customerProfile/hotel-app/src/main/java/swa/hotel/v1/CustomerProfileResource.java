package swa.hotel.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import swa.hotel.api.*;
import swa.hotel.service.CustomerProfileService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/customer-profile")
@RequiredArgsConstructor
public class CustomerProfileResource {

    private final CustomerProfileService customerProfileService;

    @GetMapping
    public GetCustomersResponse getCustomers() {

        return customerProfileService.getCustomers();
    }

    @GetMapping(value = "/{id}",
            produces = APPLICATION_JSON_VALUE)
    public GetCustomerResponse getCustomer(@PathVariable String id) {

        var request = new GetCustomerRequest();
        request.setId(id);

        return customerProfileService.getCustomer(request);
    }

    @GetMapping(value = "/{id}/orders",
            produces = APPLICATION_JSON_VALUE)
    public GetCustomerOrdersResponse getCustomerOrders(@PathVariable String id) {

        var request = new GetCustomerOrdersRequest();
        request.setId(id);

        return customerProfileService.getCustomerOrders(request);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody CreateCustomerRequest request) {

        customerProfileService.createCustomer(request);
    }

}
