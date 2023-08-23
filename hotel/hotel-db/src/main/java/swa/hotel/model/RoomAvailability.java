package swa.hotel.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "ROOM_AVAILABILITY")
@Entity
@Data
public class RoomAvailability {

    @Id
    @GeneratedValue
    private Long id;

    private Long roomId;
    private Long hotelId;
    private Long customerId;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    private boolean isRelevant;

}
