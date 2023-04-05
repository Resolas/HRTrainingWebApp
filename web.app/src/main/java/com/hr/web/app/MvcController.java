package com.hr.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// MvcController is what directs the user to the login upon entering webapp or localhost/8080

@Controller
public class MvcController {

	
	@GetMapping("/")
    public String root() {
        return "redirect:/login";
    }
	
}

@Controller
class AdminController {
	@GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}

@Controller
class UserController {
	@GetMapping("/user")
    public String user() {
        return "user";
    }
}



