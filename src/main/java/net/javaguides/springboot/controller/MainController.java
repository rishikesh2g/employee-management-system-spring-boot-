package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    // which marks it as a Spring MVC controller.
public class MainController {

	@GetMapping("/login")     //for mapping HTTP GET requests onto specific handler method.
	public String login() {
		return "login";
	}
	
	@Controller
	public class AboutController {

	    @GetMapping("/About")
	    public String aboutPage() {
	        return "About";
	    }
	}
	
	@Controller
	public class HomeController {

	    @GetMapping("/Home")
	    public String aboutPage() {
	        return "Home";
	    }
	}
	/*
	 * @GetMapping("/") public String home() { return "index"; }
	 */
}
