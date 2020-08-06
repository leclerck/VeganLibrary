package cl.leclerck.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.leclerck.model.dao.CustomerDao;
import cl.leclerck.model.entity.Customer;


@Service
public class AuthServiceImpl implements UserDetailsService {
    
    private Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    
    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        
        Customer customer = customerDao.findByUsername(username).orElse(null);
        
        User user = null;
        
        if(customer != null) {
            String role = customer.getRole().toString();
            String username_ = customer.getUsername();
            String password_ = customer.getPassword();
            logger.warn("Customer found, username: " + username);
            
            // agregamos el rol a la lista de roles
            List<SimpleGrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority(role));
            // acá se hace el login !!!
            user = new User(username_, password_, roles);
           
        }else {
            logger.warn("Customer couldn't be found :" + username);
        }
        
        return user;
    }

}
