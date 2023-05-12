package com.hr.web.app;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;

// MvcController is what directs the user to the login upon entering webapp or localhost/8080

/* Code Templates Use Them :I
		Add this in the respective controllers you wish to them to be in

@GetMapping("/mypage")
    public String mypage() {
        return "mypage";
    }



 */


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

	// To connect new pages

	@GetMapping("/evaluationpart1")
	public String evaluationpart1()
	{

		return "evaluationpart1";

	}

	@GetMapping("/evaluationpart2")
	public String evaluationpart2()
	{

		return "evaluationpart2";

	}


}



