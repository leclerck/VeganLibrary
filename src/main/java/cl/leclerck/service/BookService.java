package cl.leclerck.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cl.leclerck.model.dao.BookDao;
import cl.leclerck.model.entity.Book;
import cl.leclerck.model.entity.Review;
import cl.leclerck.service.utils.FileUtilsBooks;

@Service
public class BookService {
	private final Logger logger = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookDao dao;

	@Autowired
	private FileUtilsBooks fileUtils;

	@Transactional(readOnly = true)
	public List<Book> getAll() {
		return dao.findAll();
	}

	public Book register(Book book, MultipartFile picture, MultipartFile file) {
		logger.info("Registering book: " + book.toString());
		String pictureName = fileUtils.uploadPicture(picture);
		String fileName = fileUtils.uploadFile(file);
		book.setPictureUrl(pictureName);
		book.setFileUrl(fileName);
		book.setId(null);
		return dao.save(book);
	}
	
	public Book register(Book book) {
		logger.info("Registering book: " + book.toString());
		book.setId(null);
		return dao.save(book);
	}

	public Book search(Integer id) {
		return dao.findById(id).orElse(null);
	}

	public Book delete(Book book) {
		String pictureName = book.getPictureUrl();
		boolean deletedPicture = fileUtils.deletePictureByName(pictureName);

		if (!deletedPicture) {
			logger.error("File " + pictureName + " couldn't be deleted");
		}
		String fileName = book.getFileUrl();
		boolean deletedFile = fileUtils.deletePictureByName(fileName);

		if (!deletedFile) {
			logger.error("File " + fileName + " couldn't be deleted");
		}
		
		dao.delete(book);

		return book;
	}

	public Book update(Book book) {
		return dao.save(book);
	}

	public Book update(Book book, MultipartFile file) {
		Book previousBook = dao.findById(book.getId()).orElse(null);
		// eliminamos la imagen anterior
		fileUtils.deletePictureByName(previousBook.getPictureUrl());
		fileUtils.deleteFileByName(previousBook.getFileUrl());
		// subimos la nueva
		String nombreArchivo = fileUtils.uploadFile(file);
		// actualizamos el registro en la base de datos
		book.setPictureUrl(nombreArchivo);

		return dao.save(book);
	}

	public double calculateStars(Book book) {
		double stars = 0;
		for(Review review : book.getReviews()) {
			stars+=review.getStars();
		}
		return stars;

	}
}
