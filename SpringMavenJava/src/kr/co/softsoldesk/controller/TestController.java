package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data() {
		String view  = "Input_data";
		return view;
	}
	
	
}
