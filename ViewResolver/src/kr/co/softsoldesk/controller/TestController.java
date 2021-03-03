package kr.co.softsoldesk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jdk.internal.icu.text.NormalizerBase.Mode;

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
	

	@GetMapping("/test3")
	public String Test3_Get(Model model) {
		//Model객체로 Add하면 Request객체에 담긴다.
		model.addAttribute("data1", 300);
		model.addAttribute("data2", 400);
		return "Test3";
	}
	@GetMapping("/test4")
	public ModelAndView Test4_Get(ModelAndView mv) {
		mv.addObject("data1", 100);
		mv.addObject("data2", 200);
		///ViewName 지정, view네임이란 view단의 이름이므로, 보통 jsp의 위치를 지정하게 된다.
		mv.setViewName("Test4");
		return mv;
	}
}
