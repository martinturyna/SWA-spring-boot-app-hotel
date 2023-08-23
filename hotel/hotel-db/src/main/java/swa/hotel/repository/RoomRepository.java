package swa.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swa.hotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
