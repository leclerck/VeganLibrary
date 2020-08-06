package cl.leclerck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import cl.leclerck.model.entity.Book;
import cl.leclerck.model.entity.Customer;
import cl.leclerck.model.entity.Role;
import cl.leclerck.service.BookService;
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

	@Autowired
	private BookService bookService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Customer admin = new Customer();
		admin.setUsername("admin");
		admin.setEmail("admin@hola.cl");
		admin.setPassword("1234");
		admin.setRole(Role.ROLE_ADMIN);
		customerService.signIn(admin);

		Customer customer = new Customer();
		customer.setUsername("vale");
		customer.setPassword("0000");
		customer.setRole(Role.ROLE_USER);
		customer.setEmail("vale@hola.cl");
		customer.setAvatarUrl("cute96.jpg");
		customerService.signIn(customer);

		Book book1 = new Book();
		book1.setAuthor("Deborah Madison");
		book1.setDescription(
				"Proin bibendum sapien eget nisl fringilla, nec eleifend nisi molestie. Vivamus vestibulum, nunc porttitor vulputate mattis, felis augue mollis turpis, non ullamcorper quam sem quis ipsum. Aliquam mattis cursus erat quis efficitur. Vivamus eu vulputate felis. Nullam tempor bibendum bibendum. Nunc vehicula ipsum non risus rutrum viverra. Pellentesque ut rutrum ipsum, sit amet volutpat sapien. Ut ornare, magna faucibus auctor viverra, tellus ex tincidunt leo, vel auctor mi quam at nisi. Donec consequat dolor eu faucibus ullamcorper. Nunc dapibus nibh tellus, et ullamcorper nisi bibendum eget. Maecenas lacinia erat at purus pharetra hendrerit. Duis tortor nibh, maximus sed est sit amet, finibus tincidunt risus. Duis accumsan, velit eget suscipit condimentum, lorem velit commodo dui, in ullamcorper ex arcu vel eros. Integer egestas condimentum accumsan. Nam vitae ex vel nisl rhoncus convallis a vel nisi. ");
		book1.setFileUrl("VegetarianCookingForEveryone.pdf");
		book1.setIsbn("0767927478");
		book1.setName("Vegetarian Cooking for Everyone");
		book1.setPictureUrl("vegetarianCooking.jpg");
		book1.setYear(2007);
		bookService.register(book1);

		Book book2 = new Book();
		book2.setAuthor("Melanie Joy");
		book2.setDescription(
				"Maecenas nunc odio, facilisis eget sem id, elementum finibus risus. Sed iaculis purus sit amet posuere condimentum. Fusce feugiat scelerisque enim ut tincidunt. Morbi id condimentum tellus, vitae consectetur nulla. Nam id rhoncus lectus. Aenean pellentesque erat in blandit rhoncus. Quisque placerat, quam luctus maximus faucibus, leo mi facilisis nisi, vel scelerisque dolor orci ut est. Praesent condimentum dolor ipsum, eu molestie lacus accumsan in. In eget pharetra ex. In hac habitasse platea dictumst. Vivamus a nulla magna. Sed ullamcorper enim nec felis pellentesque sollicitudin. Proin varius egestas odio nec convallis. Morbi ultrices, enim ut elementum consectetur, mi dui eleifend nibh, id cursus ante erat non arcu. Duis rutrum semper enim, non porttitor nibh iaculis ac. ");
		book2.setFileUrl("Joy-Why-We-Love-Dogs-Eat-Pigs-and-Wear-Cows-An-Introduction-to-Carnism-2009");
		book2.setIsbn("1573245054");
		book2.setName("Why we love dogs eat pigs and wear cows");
		book2.setPictureUrl("whywe.jpg");
		book2.setYear(2011);
		bookService.register(book2);

	}

}
