package swa.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swa.hotel.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
