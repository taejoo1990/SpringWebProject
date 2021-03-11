package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String input_data() {
		String view  = "Test1";
		return view;
	}
	
	
}
