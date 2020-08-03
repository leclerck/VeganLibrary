package cl.leclerck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.leclerck.model.entity.Book;
import cl.leclerck.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
    private BookService service;
	
	@GetMapping("/books")
	public String bookMaintainer() {
		return "admin/bookMaintainer";
	}
	
	@GetMapping
    public String home(
        @ModelAttribute("message") String message, 
        ModelMap map
    ) {
        if(message != null)
            map.put("message", message);
        map.put("books", service.getAll());

        return "admin/bookMaintainer";
    }
	
	@PostMapping("/update")
    public String update(
        ModelMap map,
        RedirectAttributes attributes,
        @ModelAttribute Book book	, 
        @RequestParam(name = "pictureUrl", required = false) MultipartFile file) {
        if(file.isEmpty())
            service.update(book);
        else
            service.update(book, file);
        
        attributes.addFlashAttribute("message", "Book updated");
        
        return "redirect:/books";
    }
	
	@PostMapping
    public String register(
        RedirectAttributes attributes,
        @ModelAttribute Book book, 
        @RequestParam("picture") MultipartFile file) {
        Book responseBook = service.register(book, file); 
        
        attributes.addFlashAttribute(
            "message", 
            "Book " 
            + responseBook.getName()
            + " registered."
        );

        return "redirect:/books";
    }

    @GetMapping(value = "/delete")
    public String delete(
        @RequestParam Integer id, 
        RedirectAttributes attributes) {
        Book book = service.search(id);
        service.delete(book);
        String message = "Book: " + book.getName() + " deleted";
        attributes.addFlashAttribute("message", message);

        return "redirect:/books";
    }

}
