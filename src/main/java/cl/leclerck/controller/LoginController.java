package cl.leclerck.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping
    public String showLogin(
        ModelMap viewMap,
        @RequestParam(name = "error", required = false) String error) {
        if (error != null) {
            viewMap.put("error", true);
        }

        return "/auth/login";
    }

    @GetMapping("/denied-page")
    public String forbidden() {
        return "error/403";
    }

    @GetMapping("/goLogout")
    public String showLogOut() {
        return "auth/logout";
    }
    
    @GetMapping("/logout")
    public String logOut() {
    SecurityContextHolder.getContext().setAuthentication(null);
    return "auth/login";
    }
    @GetMapping("/signin")
    public String showSignIn() {
        return "auth/signin";
    }

}
