package cl.leclerck.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cl.leclerck.model.dao.CustomerDao;
import cl.leclerck.model.entity.Book;
import cl.leclerck.model.entity.Customer;
import cl.leclerck.service.utils.FileUtils;

@Service
public class CustomerService {
	private final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private CustomerDao dao;
    
    @Autowired
    private FileUtils files;

    @Transactional(readOnly = true)
    public List<Customer> getAll(){
        return dao.findAll();
    }
    
    public Customer signIn(Customer customer, MultipartFile file) {
        logger.info("Signing in customer: " + customer.toString());
        String fileName = files.uploadFile(file);
        customer.setAvatarUrl(fileName);
        customer.setId(null);
        return dao.save(customer);
    }
    
    public Customer search(Integer id) {
        return dao.findById(id).orElse(null);    
    }
    
    public Customer delete(Customer customer) {
        String fileName = customer.getAvatarUrl();
        boolean deletedFile = files.deleteFileByName(fileName);

        if(!deletedFile) {
            logger.error("File " + fileName + " couldn't be deleted");
        }
        
        dao.delete(customer);
        
        return customer;
    }

    public Customer update(Customer customer) {
        return dao.save(customer);
    }

    public Customer update(Customer customer, MultipartFile file) {
    	Customer previousBook = dao.findById(customer.getId()).orElse(null);
        // eliminamos la imagen anterior
        files.deleteFileByName(previousBook.getAvatarUrl());
        // subimos la nueva
        String nombreArchivo = files.uploadFile(file);
        // actualizamos el registro en la base de datos
        customer.setAvatarUrl(nombreArchivo);

        return dao.save(customer);
    }
    
}
