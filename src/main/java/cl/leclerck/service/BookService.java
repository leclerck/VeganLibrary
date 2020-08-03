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
import cl.leclerck.service.utils.FileUtils;

@Service
public class BookService {
    private final Logger logger = LoggerFactory.getLogger(BookService.class);
    
    @Autowired
    private BookDao dao;
    
    @Autowired
    private FileUtils files;
    
    @Transactional(readOnly = true)
    public List<Book> getAll(){
        return dao.findAll();
    }
    
    public Book register(Book book, MultipartFile file) {
        logger.info("Registering book: " + book.toString());
        String fileName = files.uploadFile(file);
        book.setPictureUrl(fileName);
        book.setId(null);
        return dao.save(book);
    }
    
    public Book search(Integer id) {
        return dao.findById(id).orElse(null);    
    }
    
    public Book delete(Book book) {
        String fileName = book.getPictureUrl();
        boolean deletedFile = files.deleteFileByName(fileName);

        if(!deletedFile) {
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
        files.deleteFileByName(previousBook.getPictureUrl());
        // subimos la nueva
        String nombreArchivo = files.uploadFile(file);
        // actualizamos el registro en la base de datos
        book.setPictureUrl(nombreArchivo);

        return dao.save(book);
    }
    
    
}

