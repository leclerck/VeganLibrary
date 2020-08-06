package cl.leclerck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.leclerck.model.entity.Book;
import cl.leclerck.model.entity.Review;
import cl.leclerck.service.BookService;
import cl.leclerck.service.ReviewService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public String home(@ModelAttribute("message") String message, ModelMap map) {
		if (message != null)
			map.put("message", message);
		map.put("books", bookService.getAll());

		return "admin/bookMaintainer";
	}

	@PostMapping("/update")
	public String update(ModelMap map, RedirectAttributes attributes, @ModelAttribute Book book,
			@RequestParam(name = "picture", required = false) MultipartFile file) {
		if (file.isEmpty())
			bookService.update(book);
		else
			bookService.update(book, file);

		attributes.addFlashAttribute("message", "Book updated");

		return "redirect:/books";
	}

	@PostMapping
	public String register(RedirectAttributes attributes, @ModelAttribute Book book,
			@RequestParam("picture") MultipartFile picture, @RequestParam("file") MultipartFile file) {
		Book responseBook = bookService.register(book, picture, file);

		attributes.addFlashAttribute("message", "Book " + responseBook.getName() + " registered.");

		return "redirect:/books";
	}

	@GetMapping(value = "/delete")
	public String delete(@RequestParam Integer id, RedirectAttributes attributes) {
		Book book = bookService.search(id);
		bookService.delete(book);
		String message = "Book: " + book.getName() + " deleted";
		attributes.addFlashAttribute("message", message);

		return "redirect:/books";
	}

	@GetMapping("/detail")
	public String showBook(@RequestParam("id") int idBook, Model model) {
		Book book = bookService.search(idBook);
		model.addAttribute("book", book);

		return "home/details";
	}

	/*
	 * implementar carga de reviews
	 */
	@PostMapping("/detail?id={book.id}")
	public String postReview(@ModelAttribute("message") String message, ModelMap viewMap, RedirectAttributes attributes,
			@ModelAttribute Review review, @RequestParam("id") int idBook) {
//		reviewService.postReview(review);
		Book book = bookService.search(idBook);
		List<Review>bookReviews = book.getReviews();
//		viewMap.put("reviews", bookReviews);
			
//		attributes.addAttribute("id", book.getId()).addFlashAttribute("message", "Your review was posted");
		
		if (message != null)
			viewMap.put("message", message);
		viewMap.put("reviews", bookReviews);		
		
		return "/books/detail?id=${idBook}";
	}
}
