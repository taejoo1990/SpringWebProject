package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sub2")
public class Sub2Controller {

	@RequestMapping(value="/Test5", method = RequestMethod.GET)
	public String test5() {
		
		return "sub2/Test5";
	}
	@RequestMapping(value="/Test6", method = RequestMethod.GET)
	public String test6() {
		
		return "sub2/Test6";
	}
}
