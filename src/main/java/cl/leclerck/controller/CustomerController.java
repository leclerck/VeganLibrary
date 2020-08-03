package cl.leclerck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class CustomerController {

	@GetMapping("/signin")
	public String showLogin() {
		return "user/signin";
	}

	@GetMapping("/users")
	public String bookMaintainer() {
		return "admin/userMaintainer";

	}
}
