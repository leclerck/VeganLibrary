package cl.leclerck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import cl.leclerck.model.entity.Customer;
import cl.leclerck.model.entity.Role;
import cl.leclerck.service.CustomerService;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}
}

@Component
class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private CustomerService customerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Customer customer = new Customer();
		customer.setUsername("admin");
//            customer.setEmail("admin@mail.com");
		customer.setPassword("1234");
		customer.setRole(Role.ROLE_ADMIN);

		customerService.signIn(customer);

//		customer.setUsername("user");
//		customer.setEmail("user@mail.com");
//		customer.setPassword("1234");
//		customer.setRole(Role.ROLE_USER);
//		customerService.signIn(customer, null);
		
		//Cargar libro aqui

	}

}
