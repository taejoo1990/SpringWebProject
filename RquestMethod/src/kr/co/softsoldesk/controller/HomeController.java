package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	//클라이언트가 어디서든 주소를 요청하면 String Home()을 호출함
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String Home() {
		System.out.println("Home");
		
		return "Index";
	}
	@RequestMapping(value = "/test1", method=RequestMethod.GET)
	public String Hometest1_Get() {
		System.out.println("Home");
		
		return "Test1";
	}
	@RequestMapping(value = "/test2", method=RequestMethod.POST)
	public String Hometest2_Post() {
		System.out.println("Home");
		
		return "Test2";
	}
	@RequestMapping(value = "/test3", method=RequestMethod.GET)
	public String Hometest3_Get() {
		System.out.println("Home");
		
		return "Test3_get";
	}
	@RequestMapping(value = "/test3", method=RequestMethod.POST)
	public String Hometest3_Post() {
		System.out.println("Home");
		return "Test3_post";
	}
	
	@GetMapping("/test4")
	public String HomeTest4_Get() {
	return "Test4";
	}
	@PostMapping("/test5")
	public String HomeTest5_Post() {
		return "Test5";
	}
	@GetMapping("/test6")
	public String HomeTest6_Get() {
		return "Test6_Get";
	}
	@PostMapping("/test6")
	public String HomeTest6_Post() {
		return "Test6_Post";
	}
	@RequestMapping(value = "/test7" , method = {RequestMethod.POST , RequestMethod.GET})
	public String HomeTest7() {
		return "Test7";
	}
	@GetMapping("/test8")
	public String HomeTest8_Get() {
		return "Test8";
	}
	@PostMapping("/test8")
	public String HomeTest8_Post() {
		return "Test8";
	}
}

