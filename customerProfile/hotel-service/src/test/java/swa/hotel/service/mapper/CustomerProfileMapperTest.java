package swa.hotel.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swa.hotel.api.enums.Gender;
import swa.hotel.api.model.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerProfileMapperTest {

    private static final String FIRST_NAME_TEST = "FIRSTNAME";
    private static final String LAST_NAME_TEST  = "LASTNAME";

    private static final Gender GENDER_TEST = Gender.MALE;

    private CustomerProfileMapper mapper;

    @BeforeEach
    void setup() {

        mapper = new CustomerProfileMapper();
    }

    @Test
    void mapToCustomerTest() {

        var customer = mapper.mapToCustomer(mockDbCustomer());

        assertNotNull(customer);
        assertEquals(customer.getFirstName(), FIRST_NAME_TEST);
        assertEquals(customer.getLastName(), LAST_NAME_TEST);
        assertEquals(customer.getGender(), GENDER_TEST);
    }

    @Test
    void mapToDbCustomerTest() {

        var dbCustomer = mapper.mapToDbCustomer(mockCustomer());

        assertNotNull(dbCustomer);
        assertEquals(dbCustomer.getFirstName(), FIRST_NAME_TEST);
        assertEquals(dbCustomer.getLastName(), LAST_NAME_TEST);
        assertEquals(dbCustomer.getGender(), GENDER_TEST);
    }

    private Customer mockCustomer() {

        var customer = new Customer();
        customer.setGender(GENDER_TEST);
        customer.setFirstName(FIRST_NAME_TEST);
        customer.setLastName(LAST_NAME_TEST);

        return customer;
    }

    private swa.hotel.model.Customer mockDbCustomer() {

        var customer = new swa.hotel.model.Customer();
        customer.setGender(GENDER_TEST);
        customer.setFirstName(FIRST_NAME_TEST);
        customer.setLastName(LAST_NAME_TEST);

        return customer;
    }

}
