package cl.leclerck.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@GetMapping("index")
	public String bookMaintainer() {
		return "admin/bookMaintainer";
	}
	
//	@GetMapping
//	public String index(ModelMap map) {
//		map.put("book", service.getAll());
//		return "book/index";
//	}

}
