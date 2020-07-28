package cl.leclerck.controller;

import java.util.ArrayList;
import java.util.List;

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
}

