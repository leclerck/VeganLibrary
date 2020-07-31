package cl.leclerck.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.leclerck.model.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
}
//extends JpaRepository<Book, Integer>