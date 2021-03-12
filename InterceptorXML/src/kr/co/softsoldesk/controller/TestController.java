package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String Test1() {
		String view  = "Test1";
		System.out.println("Test1");
		return view;
	}
	@GetMapping("/test2")
	public String Test2() {
		String view  = "Test2";
		System.out.println("Test2");
		return view;
	}
	
	@GetMapping("/sub1/test3")
	public String Test3() {
		String view  = "Test3";
		System.out.println("Test3");
		return view;
	}
	
	@GetMapping("/sub1/test4")
	public String Test4() {
		String view  = "Test4";
		System.out.println("Test4");
		return view;
	}
	
	
	
}
