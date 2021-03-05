package kr.co.softsoldesk.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;
import kr.co.softsoldesk.beans.DataBean3;
import kr.co.softsoldesk.beans.DataBean4;

@Controller
public class TestControeller {
	
	
	//자동주입
	@Autowired
	DataBean1 requestBean1;
	
	//이름으로 주입
	@Resource(name = "requestBean2")
	DataBean2 requestBean2;
	
	//컴포넌트로 주입
	@Autowired
	DataBean3 requestBean3;
	
	//컴포넌트 이름으로 주입
	@Resource(name = "requestBean4")
	DataBean4 requestBean4;
	
	
	
	@GetMapping("/test1")
	public String Test1_Get() {
		requestBean1.setData1("문자1");
		requestBean1.setData2("문자2");
	return "forward:/result1"; //새로운 요청이 발생하는 것이 아니기 때문에 DataBean1의 주입이 발생하지 않음
	}
	
	@GetMapping("/result1")
	public String Result1(Model model) {
		System.out.println(requestBean1.getData1());
		System.out.println(requestBean1.getData2());
		
		model.addAttribute(requestBean1);
		return "Test1";
	}
	

	
	@GetMapping("/test2")
	public String Test2_Get() {
		requestBean2.setData3("문자3");
		requestBean2.setData4("문자4");
	return "forward:/result2"; //새로운 요청이 발생하는 것이 아니기 때문에 DataBean1의 주입이 발생하지 않음
	}
	
	@GetMapping("/result2")
	public String Result2(Model model) {
		System.out.println(requestBean2.getData3());
		System.out.println(requestBean2.getData4());
		
		model.addAttribute(requestBean2);
		return "Test2";
	}
	//===============================================
	@GetMapping("/test3")
	public String Test3_Get() {
		requestBean3.setData5("문자5");
		requestBean3.setData6("문자6");
	return "forward:/result3"; //새로운 요청이 발생하는 것이 아니기 때문에 DataBean1의 주입이 발생하지 않음
	}
	
	@GetMapping("/result3")
	public String Result5(Model model) {
		System.out.println(requestBean3.getData5());
		System.out.println(requestBean3.getData6());
		
		model.addAttribute(requestBean3);
		return "Test3";
	}
	
	//===================================================
	@GetMapping("/test4")
	public String Test4_Get() {
		requestBean4.setData7("문자7");
		requestBean4.setData8("문자8");
	return "forward:/result4"; //새로운 요청이 발생하는 것이 아니기 때문에 DataBean1의 주입이 발생하지 않음
	}
	
	@GetMapping("/result4")
	public String Result4(Model model) {
		System.out.println(requestBean4.getData7());
		System.out.println(requestBean4.getData8());
		
		model.addAttribute(requestBean4);
		return "Test4";
	}
}
