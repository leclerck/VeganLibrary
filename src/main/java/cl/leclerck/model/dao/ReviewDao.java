package cl.leclerck.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.leclerck.model.entity.BookUser;
import cl.leclerck.model.entity.Review;

public interface ReviewDao extends JpaRepository<Review, BookUser> {}
