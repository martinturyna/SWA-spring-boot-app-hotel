package swa.hotel.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "ROOM")
@Entity
@Data
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private int roomNumber;
    private int floor;
    private int bedCount;

    @ManyToOne
    @JoinColumn(name="hotel_id", nullable=false)
    private Hotel hotel;

}
