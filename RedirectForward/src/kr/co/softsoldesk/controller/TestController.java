package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String Test1() {
		//return "Test1";
		return "redirect:/sub1";
	}
	
	@GetMapping("/sub1")
	public String sub1() {
		return "Sub1";
	}
	
	@GetMapping("/test2")
	public String Test2() {
		return "forward:/sub1";
	}
	
	
}
