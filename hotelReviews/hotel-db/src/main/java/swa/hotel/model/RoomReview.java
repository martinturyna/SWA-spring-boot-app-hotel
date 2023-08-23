package swa.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ROOM_REVIEW")
@Entity
@Data
public class RoomReview {

    @Id
    @GeneratedValue
    private Long id;

    private Long customerId;
    private Long roomId;
    private Long rating;

    private String description;

}
