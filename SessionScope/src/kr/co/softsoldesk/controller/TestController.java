package kr.co.softsoldesk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.softsoldesk.beans.DataBean1;

@Controller
//컨트롤러에 들어올 때, 설정된 이름의 메서드를 찾아라. 
//해당메서드는 빈을 선언하는 형식
@SessionAttributes({"sessionBean1","sessionBean2"})
public class TestController {
	
	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();
	}
	@ModelAttribute("sessionBean2")
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}

	
	@GetMapping("/test1")
	public String test1(HttpServletRequest req) {
		HttpSession session=req.getSession();
		session.setAttribute("data1", "문자열");
		return "Test1";
	}
	/*
	@GetMapping("result1")
	public String result1(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String data1=(String)session.getAttribute("data1");
		System.out.println("data1 =" + data1);
		return "Result1";
	}*/
	
	//=================================================
	

	
	@GetMapping("result1")
	public String result1(HttpSession session) {
		String data1=(String)session.getAttribute("data1");
		String data2=(String)session.getAttribute("data2");
		String data3=(String)session.getAttribute("data3");
		System.out.println("data1 =" + data1);
		return "Result1";
	}
	
	//=======================================================
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data2", "문자열2");
		String view = "redirect:/result1";
		return view;
	}
	
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data3", "문자열3");
		String view = "forward:/result1";
		return view;
	}
	//=======================================================
	/*
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		String view = "Test4";
		
		DataBean1 bean = new DataBean1();
		bean.setData1("문자4");
		bean.setData2("문자5");
		
		session.setAttribute("DataBean", bean);
		
		return view;
	}
	
	@GetMapping("/result4")
	public String result4(HttpSession session) {
		String view = "Result2";
		DataBean1 bean = (DataBean1)session.getAttribute("DataBean");
		System.out.printf("Data4 : %s\n", bean.getData1() );
		System.out.printf("Data5 : %s\n", bean.getData2() );
		return view;
	}*/
	
	//===========================================================
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		String view = "Test4";
		
		DataBean1 bean = new DataBean1();
		bean.setData1("문자4");
		bean.setData2("문자5");
		
		session.setAttribute("DataBean", bean);
		
		return view;
	}
	
	@GetMapping("/result2")
	public String result4(@SessionAttribute("DataBean") DataBean1 bean) {
		String view = "Result2";
		
		System.out.printf("Data4 : %s\n", bean.getData1() );
		System.out.printf("Data5 : %s\n", bean.getData2() );
		return view;
	}
	
	//===========================================================
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 bean,@ModelAttribute("sessionBean2") DataBean1 bean2) {
		String view = "Test5";
		bean.setData1("문자6");
		bean.setData2("문자7");
		
		bean2.setData1("문자8");
		bean2.setData2("문자9");
		return view;
	}
	
	@GetMapping("/result3")
	public String result3(@ModelAttribute("sessionBean1") DataBean1 bean,@ModelAttribute("sessionBean2") DataBean1 bean2) {
		String view = "Result3";
		
		System.out.printf("Data4 : %s\n", bean.getData1() );
		System.out.printf("Data5 : %s\n", bean.getData2() );
		System.out.printf("Data4 : %s\n", bean2.getData1() );
		System.out.printf("Data5 : %s\n", bean2.getData2() );
		return view;
	}
}
