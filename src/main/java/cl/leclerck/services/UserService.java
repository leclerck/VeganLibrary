package cl.leclerck.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.leclerck.model.dao.UserDao;
import cl.leclerck.model.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public List<User> obtenerTodos(){
        return dao.findAll();
    }
    
    
}
