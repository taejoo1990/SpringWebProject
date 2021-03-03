package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.softsoldesk.Beans.DataBean;

@Controller
public class TestController {

	
	@GetMapping("test1")
	public String Test1_Get(@ModelAttribute("DataBean") DataBean bean) {
		bean.setA1("abcChoco");
		bean.setA2("Ted");
		bean.setA3("12345");
		bean.setA4("123-664, Jongro-Gu, Seoul, Republic Korea of");
		return "Test1";
	}
}
