package swa.hotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swa.hotel.api.*;
import swa.hotel.repository.CustomerRepository;
import swa.hotel.service.async.AsyncCaller;
import swa.hotel.service.mapper.CustomerProfileMapper;
import swa.hotel.service.mapper.OrderMapper;
import swa.hotel.service.validator.CustomerProfileValidator;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProfileService {

    private final AsyncCaller asyncCaller;

    private final CustomerRepository customerRepository;

    private final CustomerProfileMapper customerProfileMapper;

    private final OrderMapper orderMapper;

    private final CustomerProfileValidator customerProfileValidator;

    public GetCustomersResponse getCustomers() {

        var dbCustomers = customerRepository.findAll();
        customerProfileValidator.validateCustomers(dbCustomers);

        var customers = dbCustomers.stream()
                .map(customerProfileMapper::mapToCustomer)
                .collect(Collectors.toList());

        var response = new GetCustomersResponse();
        response.setCustomers(customers);

        return response;
    }

    public GetCustomerResponse getCustomer(GetCustomerRequest request) {

        customerProfileValidator.validateGetCustomerRequest(request);

        var dbCustomer = customerRepository.findById(Long.valueOf(request.getId()));
        customerProfileValidator.validateCustomer(dbCustomer);

        var response = new GetCustomerResponse();
        response.setCustomer(customerProfileMapper.mapToCustomer(dbCustomer.get()));

        return response;
    }

    public GetCustomerOrdersResponse getCustomerOrders(GetCustomerOrdersRequest request) {

        customerProfileValidator.validateGetCustomerOrdersRequest(request);
        var customerBookings = asyncCaller.getBookings(request.getId()).join();

        customerProfileValidator.validateGetBookingsResponse(customerBookings);

        var response = new GetCustomerOrdersResponse();
        response.setOrders(customerBookings.getBookings().stream()
                .map(booking -> {
                    var hotelResponse = asyncCaller.getHotel(booking.getHotelId()).join();
                    return orderMapper.mapBookingToOrder(booking, hotelResponse.getHotel());
                })
                .collect(Collectors.toList()));

        return response;
    }

    public void createCustomer(CreateCustomerRequest request) {

        var dbCustomer = customerProfileMapper.mapToDbCustomer(request.getCustomer());
        customerRepository.save(dbCustomer);
    }

}
