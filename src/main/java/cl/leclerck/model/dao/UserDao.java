package cl.leclerck.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.leclerck.model.entity.Customer;

public interface UserDao extends JpaRepository<Customer, Integer> {}
