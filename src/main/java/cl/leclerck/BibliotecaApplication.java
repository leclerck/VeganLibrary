package cl.leclerck;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import cl.leclerck.model.entity.Book;
import cl.leclerck.model.entity.BookCustomer;
import cl.leclerck.model.entity.Customer;
import cl.leclerck.model.entity.Review;
import cl.leclerck.model.entity.Role;
import cl.leclerck.service.BookService;
import cl.leclerck.service.CustomerService;
import cl.leclerck.service.ReviewService;

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
	
	@Autowired
	private ReviewService reviewService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Date date1 = new Date(12/06/2020);
		Date date2 = new Date(22/07/2020);
		Date date3 = new Date(9/05/2020);
		
		Customer admin = new Customer();
		admin.setUsername("admin");
		admin.setEmail("admin@hola.cl");
		admin.setPassword("1234");
		admin.setRole(Role.ROLE_ADMIN);
		customerService.signIn(admin);

		Customer customer1 = new Customer();
		customer1.setUsername("vale");
		customer1.setPassword("0000");
		customer1.setRole(Role.ROLE_USER);
		customer1.setEmail("vale@hola.cl");
		customer1.setAvatarUrl("cute96.jpg");
		customerService.signIn(customer1);
		
		Customer customer2 = new Customer();
		customer2.setUsername("dani");
		customer2.setPassword("9876");
		customer2.setRole(Role.ROLE_USER);
		customer2.setEmail("dani@hola.cl");
		customer2.setAvatarUrl("geest1.jpg");
		customerService.signIn(customer2);

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
		
		Book book3 = new Book();
		book3.setAuthor("Frances Moore Lappe");
		book3.setDescription("Aliquam eleifend blandit felis, vehicula volutpat tellus imperdiet eleifend. Cras aliquam semper lacus bibendum maximus. Sed vitae viverra augue, nec lacinia mi. Donec nec volutpat velit. Proin dignissim justo vitae erat pellentesque, sit amet porttitor sapien tristique. Aliquam eu sapien nisi. Ut lacinia metus nec nulla volutpat, at pretium augue dictum. Curabitur mattis ligula ut nisl laoreet, quis semper elit hendrerit.");
		book3.setFileUrl("diet-for-a-small-planet.pdf");
		book3.setIsbn("978-0-307-75453-0");
		book3.setName("Diet for a small planet");
		book3.setPictureUrl("DietForASmallPlanet.jpg");
		book3.setYear(1991);
		bookService.register(book3);
		
		BookCustomer bc1 = new BookCustomer();
		bc1.setBook(book1.getId());
		bc1.setCustomer(customer1.getId());
		
		BookCustomer bc2 = new BookCustomer();
		bc2.setBook(book2.getId());
		bc2.setCustomer(customer2.getId());
		
		BookCustomer bc3 = new BookCustomer();
		bc3.setBook(book2.getId());
		bc3.setCustomer(customer2.getId());
		
		Review review1 = new Review();
		review1.setContent("Morbi iaculis eleifend interdum. Suspendisse eget vulputate lorem, ac blandit purus. Vivamus dapibus lectus ac convallis scelerisque. Maecenas mauris ex, congue vel felis eu, suscipit eleifend odio. Aliquam sollicitudin sem quam, aliquet gravida orci dictum et. Nunc varius pharetra diam, lacinia laoreet ex aliquam id. Cras sed egestas elit, sed vulputate nunc. Curabitur leo enim, lacinia at fringilla in, dictum eu velit. Mauris et neque lorem.");
		review1.setDate(date1);
		review1.setStars(4.0);
		review1.setTitle("It was great");
		reviewService.addReview(bc1, review1);
		reviewService.postReview(review1,bc1);
		
		Review review2 = new Review();
		review2.setContent("Quisque at malesuada nunc. Aliquam arcu nisl, porta vel est eu, lacinia accumsan sem. Sed sapien turpis, dictum non tempor tempor, tristique et risus. Nunc vehicula congue massa, in tempus enim. Nunc nec ipsum sit amet dolor laoreet maximus. Quisque a sapien dui. Pellentesque eu turpis vel felis gravida blandit. Phasellus nec malesuada felis. Quisque sit amet lacinia purus. Vestibulum quam erat, feugiat sit amet ipsum ut, sodales ultricies libero. Aliquam mollis semper magna, ac luctus odio bibendum quis.");
		review2.setDate(date2);
		review2.setStars(3.0);
		review2.setTitle("Not so good");
		reviewService.addReview(bc2, review2);
		reviewService.postReview(review2,bc2);
		
		Review review3 = new Review();
		review3.setContent("Suspendisse sit amet aliquam nunc. Sed eu lobortis erat, nec laoreet magna. Quisque eget euismod felis. Suspendisse eget nulla faucibus, consectetur odio et, pellentesque tortor. Phasellus finibus ut turpis vitae finibus. Suspendisse potenti. Nunc pretium sapien tellus, vel dignissim risus commodo non. Duis est ex, porta sed eros non, aliquet efficitur sapien. ");
		review3.setDate(date3);
		review3.setStars(4.7);
		review3.setTitle("A great experience");
		reviewService.postReview(review3,bc3);
		reviewService.addReview(bc3, review3);
	}

}
