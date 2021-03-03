package kr.co.softsoldesk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String Test_Get() {
		return "Test1";
	}
	
	//=======================================
	
	@GetMapping("/test2")
	public String Test2_Get(HttpServletRequest req) {
		//data담기
		
		//HttpServletRequest의 setAttribute로 등록하고 getAttribute로 jsp에 전달
		req.setAttribute("data1", 300);
		req.setAttribute("data2", 400);

		return "Test2";
	}
}
