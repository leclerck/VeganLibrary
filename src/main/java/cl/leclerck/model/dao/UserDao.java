package cl.leclerck.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.leclerck.model.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {}
