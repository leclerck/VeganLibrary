package cl.leclerck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping
	public String index(ModelMap mapa) {
		return "home/index";
	}
	//href siempre hace GET
	@GetMapping("/about")
	public String about() {
		return "home/about";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin/userMaintainer";
	}
	
	@GetMapping("/book")
	public String showBook() {
		//single?id
		return "home/details";
	}

}


