package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String Test1(Model model) {
		String view="Test1";
		int[] array1 = {10,20,30};
		//model.addAttribute("array1",array1[0]);
		model.addAttribute("array1",array1[10]);
		return view;
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String Exception() {
		String error1 = "Error1";
		return error1;
	}
	

	
}
