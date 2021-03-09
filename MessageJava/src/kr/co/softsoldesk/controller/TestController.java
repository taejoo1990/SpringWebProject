package kr.co.softsoldesk.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String Test1(Model model, Locale locale) {
		String view="Test1";
		String a1 = res.getMessage("aaa.a1",null, null);
		String b1 = res.getMessage("bbb.b1",null, null);
		
		//null 값 처리 : { }값을 세팅
		Object [] args = {30, "홍길동"};
		String a2 = res.getMessage("aaa.a2",args, null);
		String a3 = res.getMessage("aaa.a3",args, locale);
				
		System.out.println("a1 : " +a1);
		System.out.println("b1 : " +b1);
		System.out.println("a2 : " +a2);
		System.out.println("a3 : " +a3);
		
		model.addAttribute("args",args);
		return view;
	}
}
