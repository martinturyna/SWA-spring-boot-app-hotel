package swa.hotel.api.model;

import lombok.Data;
import swa.hotel.api.enums.Gender;

@Data
public class Customer {

    private String firstName;
    private String lastName;

    private Gender gender;

}
