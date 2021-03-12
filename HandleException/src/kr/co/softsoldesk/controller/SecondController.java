package kr.co.softsoldesk.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

	@GetMapping("/test2")
	public String test2() {
		String view = "Test2";
		
		ArrayList<String> list=null;
		list.add("문자열");
		return view;
	}
	
	
	
	//이곳에 있는 컨트롤러만 잡음. 서블릿에 등록하면 모든 컨트롤러에 적용가능.
	
	/*@ExceptionHandler(NullPointerException.class)
	public String Exception() {
		String error2 = "Error2";
		return error2;
	}*/
	
}
