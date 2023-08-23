package swa.hotel.service.validator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import swa.hotel.api.GetCustomerOrdersRequest;
import swa.hotel.api.GetCustomerRequest;
import swa.hotel.model.Customer;
import swa.hotel.service.integration.hotel.api.GetBookingsResponse;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerProfileValidator extends AbstractValidator {

    private static final String NO_CUSTOMER_FOUND = "Customer(s) was not found";
    private static final String NO_BOOKING_FOUND = "Booking(s) was not found";
    private static final String FIELD_MISSING_GET_CUSTOMER_REQUEST = "GetCustomerRequest";
    private static final String FIELD_MISSING_GET_CUSTOMER_ORDERS_REQUEST = "GetCustomerOrdersRequest";
    private static final String FIELD_MISSING_CUSTOMER_ID = "customerId";

    public void validateCustomers(List<Customer> customers) {

        if (CollectionUtils.isEmpty(customers)) {

            notFound(NO_CUSTOMER_FOUND);
        }
    }

    public void validateCustomer(Optional<Customer> customer) {

        if (customer.isEmpty()) {
            notFound(NO_CUSTOMER_FOUND);
        }
    }

    public void validateGetCustomerRequest(GetCustomerRequest request) {

        if (request == null) {

            field_missing(FIELD_MISSING_GET_CUSTOMER_REQUEST);
            return;
        }

        if (StringUtils.isBlank(request.getId())) {

            field_missing(FIELD_MISSING_CUSTOMER_ID);
        }
    }

    public void validateGetCustomerOrdersRequest(GetCustomerOrdersRequest request) {

        if (request == null) {

            field_missing(FIELD_MISSING_GET_CUSTOMER_ORDERS_REQUEST);
            return;
        }

        if (StringUtils.isBlank(request.getId())) {

            field_missing(FIELD_MISSING_CUSTOMER_ID);
        }
    }

    public void validateGetBookingsResponse(GetBookingsResponse response) {

        if (response == null
                || CollectionUtils.isEmpty(response.getBookings())) {

            notFound(NO_BOOKING_FOUND);
        }
    }

}
