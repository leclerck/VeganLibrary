package cl.leclerck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.leclerck.model.entity.Customer;
import cl.leclerck.service.CustomerService;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {
	
	@Autowired
    private CustomerService service;

	@GetMapping
    public String home(
        @ModelAttribute("message") String message, 
        ModelMap map
    ) {
        if(message != null)
            map.put("message", message);
        map.put("customers", service.getAll());

        return "admin/customerMaintainer";
    }

	@GetMapping("/signin")
	public String showSignIn() {
		return "customer/signin";
	}
	

	
	@PostMapping("/update")
    public String update(
        ModelMap map,
        RedirectAttributes attributes,
        @ModelAttribute Customer customer	, 
        @RequestParam(name = "picture", required = false) MultipartFile file) {
        if(file.isEmpty())
            service.update(customer);
        else
            service.update(customer, file);
        
        attributes.addFlashAttribute("message", "Customer updated");
        
        return "redirect:/customers";
    }
	
	@PostMapping
    public String signIn(
        RedirectAttributes attributes,
        @ModelAttribute Customer customer, 
        @RequestParam("avatar") MultipartFile avatar) {

        Customer responseCustomer = service.signIn(customer, avatar); 
        
        attributes.addFlashAttribute(
            "message", 
            "Customer: " 
            + responseCustomer.getUsername()
            + " signed in."
        );

        return "redirect:/customers";
    }

    @GetMapping(value = "/delete")
    public String delete(
        @RequestParam Integer id, 
        RedirectAttributes attributes) {
    	Customer customer = service.search(id);
        service.delete(customer);
        String message = "Customer: " + customer.getUsername() + " deleted";
        attributes.addFlashAttribute("message", message);

        return "redirect:/customers";
    }
}
