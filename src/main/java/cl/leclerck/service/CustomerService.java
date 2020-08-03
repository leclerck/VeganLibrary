package cl.leclerck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.leclerck.model.dao.UserDao;
import cl.leclerck.model.entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public List<Customer> obtenerTodos(){
        return dao.findAll();
    }
    
    
}
