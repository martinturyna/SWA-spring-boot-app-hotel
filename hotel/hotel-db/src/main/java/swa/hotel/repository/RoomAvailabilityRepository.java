package swa.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swa.hotel.model.RoomAvailability;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, Long> {

    @Query("SELECT r FROM RoomAvailability r WHERE r.isRelevant = true AND r.hotelId = ?1 AND NOT ((r.dateFrom > ?2 AND r.dateFrom > ?3) OR (r.dateTo < ?2 AND r.dateTo < ?3))")
    List<RoomAvailability> findOccupiedRooms(Long hotelId, LocalDate dateFrom, LocalDate dateTo);

    @Query("SELECT r FROM RoomAvailability r WHERE r.customerId = ?1 AND r.roomId = ?2")
    List<RoomAvailability> findUserRoomBookings(Long customerId, Long roomId);

    List<RoomAvailability> findAllByCustomerId(Long customerId);

    List<RoomAvailability> findAllByRoomId(Long roomId);

}
