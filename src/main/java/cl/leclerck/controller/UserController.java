package cl.leclerck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@GetMapping("/signin")
	public String showLogin() {
		return "user/signin";
	}

	@GetMapping("index")
	public String bookMaintainer() {
		return "admin/userMaintainer";

	}
}
