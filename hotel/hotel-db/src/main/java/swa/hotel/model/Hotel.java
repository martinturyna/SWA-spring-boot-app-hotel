package swa.hotel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "HOTEL")
@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy="hotel")
    private List<Room> rooms;

}
