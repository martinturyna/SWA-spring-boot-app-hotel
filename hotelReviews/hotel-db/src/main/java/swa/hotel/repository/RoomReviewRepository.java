package swa.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swa.hotel.model.RoomReview;

import java.util.List;

@Repository
public interface RoomReviewRepository extends JpaRepository<RoomReview, Long> {

    List<RoomReview> findByRoomId(Long roomId);

}
