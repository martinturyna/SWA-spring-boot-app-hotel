package swa.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swa.hotel.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
