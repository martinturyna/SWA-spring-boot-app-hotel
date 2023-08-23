package swa.hotel.model;

import lombok.Data;
import swa.hotel.api.enums.Gender;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "CUSTOMER")
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    private Gender gender;

}
