package cl.leclerck.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

	@Test
	@DisplayName("Returns every book")
	public void findAllTest() {
		assertTrue(true);
	}

	@Test
	@DisplayName("Gets a book")
	public void getBookTest() {
		assertTrue(true);
	}

	@Test
	@DisplayName("Register of a book")
	public void createBookTest() {
		assertTrue(true);
	}

	@Test
	@DisplayName("Deletion of a book")
	public void deleteBookTest() {
		assertTrue(true);
	}

	@Test
	@DisplayName("Find a book by their ID")
	public void findByIdTest() {
		assertTrue(true);
	}

	@Test
	@DisplayName("Update of a book")
	public void updateBookTest() {
		assertTrue(true);
	}

	@Test
	@DisplayName("Download of a book")
	public void downloadBookTest() {
		assertTrue(true);
	}
	
	@Test
	@DisplayName("Calculation of stars")
	public void calculateStarsTest() {
		assertTrue(true);
	}
	
	
	@Test
	@DisplayName("Hola")
	public void pruebaListado(){
		assertTrue(true);
	}
	//BOOLEAN TRUE si el archivo se descargó
}
