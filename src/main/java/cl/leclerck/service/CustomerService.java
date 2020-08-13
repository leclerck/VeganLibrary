package cl.leclerck.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cl.leclerck.model.dao.CustomerDao;
import cl.leclerck.model.entity.Customer;
import cl.leclerck.service.utils.FileUtilsCustomers;

@Service
public class CustomerService {
	private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerDao dao;
    
    @Autowired
    private FileUtilsCustomers fileUtils;

    @Transactional(readOnly = true)
    public List<Customer> getAll(){
        return dao.findAll();
    }
    
    public Customer signIn(Customer customer, MultipartFile file) {
        logger.info("Signing in customer: " + customer.toString());
        
        if(dao.findByUsername(customer.getUsername()).orElse(null)!=null){
        	logger.warn("That username is already taken");
        }else {
        	String fileName = fileUtils.uploadFile(file);
            customer.setAvatarUrl(fileName);
        	return dao.save(customer);
        } 
        
        return null;
    }
    public Customer signIn(Customer customer) {
    	logger.info("Signing in customer: " + customer.toString());
    	
    	if(dao.findByUsername(customer.getUsername()).orElse(null)!=null){
    		logger.warn("That username is already taken");
    	}else {
    		if(customer.getAvatarUrl()==null)
    			customer.setAvatarUrl("defaultUserIcon.png");
    		customer.setId(null);
    		return dao.save(customer);
    	} 
    	
    	return customer;
    }
    
    public Customer search(Integer id) {
        return dao.findById(id).orElse(null);    
    }
    
    public Customer delete(Customer customer) {
        String fileName = customer.getAvatarUrl();
        boolean deletedFile = fileUtils.deleteFileByName(fileName);

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
    	fileUtils.deleteFileByName(previousBook.getAvatarUrl());
        String nombreArchivo = fileUtils.uploadFile(file);
        customer.setAvatarUrl(nombreArchivo);

        return dao.save(customer);
    }
    
    public String  searchByUsername(String name ) {
    	Optional<Customer> customer = Optional.empty();
    	customer = dao.findByUsername( name );
    	String username = customer.get().getUsername();
    	return username; 
    }
    
}
