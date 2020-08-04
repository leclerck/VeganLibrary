package cl.leclerck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.leclerck.model.entity.Book;
import cl.leclerck.service.BookService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	
	
	@GetMapping
	public String index(ModelMap viewMap) {
		viewMap.put("books", bookService.getAll());
		return "home/index";
	}
	//href siempre hace GET
	@GetMapping("/about")
	public String about() {
		return "home/about";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/customerMaintainer";
	}
	


}


