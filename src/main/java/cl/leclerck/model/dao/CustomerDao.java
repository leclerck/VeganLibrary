package cl.leclerck.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.leclerck.model.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByUsername(String username);
}
