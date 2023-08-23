package swa.hotel.service.mapper;

import org.springframework.stereotype.Component;
import swa.hotel.api.model.Customer;

@Component
public class CustomerProfileMapper {

    public Customer mapToCustomer(swa.hotel.model.Customer dbCustomer) {

        var customer = new Customer();
        customer.setFirstName(dbCustomer.getFirstName());
        customer.setLastName(dbCustomer.getLastName());
        customer.setGender(dbCustomer.getGender());

        return customer;
    }

    public swa.hotel.model.Customer mapToDbCustomer(Customer customer) {

        var dbCustomer = new swa.hotel.model.Customer();
        dbCustomer.setFirstName(customer.getFirstName());
        dbCustomer.setLastName(customer.getLastName());
        dbCustomer.setGender(customer.getGender());

        return dbCustomer;
    }

}
