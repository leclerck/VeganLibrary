package cl.leclerck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.leclerck.service.BookService;
import cl.leclerck.service.CustomerService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	BookService bookService;

	@GetMapping
	public String index(ModelMap viewMap) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		viewMap.addAttribute("username", username);

		String name = customerService.searchByUsername(username);
        viewMap.addAttribute("name", name);

		viewMap.put("books", bookService.getAll());
		return "home/index";
	}

	@GetMapping("/about")
	public String about() {
		return "home/about";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin/customerMaintainer";
	}

}
