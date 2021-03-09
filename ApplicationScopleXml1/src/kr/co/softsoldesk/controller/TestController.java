package kr.co.softsoldesk.controller;

import javax.annotation.Resource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;
import kr.co.softsoldesk.beans.DataBean3;
import kr.co.softsoldesk.beans.DataBean4;


@Controller
public class TestController {

	
	@Autowired
	DataBean1 applicationBean1;
	
	@Resource(name = "applicationBean2")
	DataBean2 applicationBean2;
	
	@Autowired
	DataBean3 applicationBean3;
	
	@Resource(name = "applicationBean4")
	DataBean4 applicationBean4;
	
	@GetMapping("/test1")
	public String test1() {
		applicationBean1.setData1("data1");
		applicationBean1.setData2("data2");
		
		applicationBean2.setData3("data3");
		applicationBean2.setData4("data4");
		
		applicationBean3.setData5("data5");
		applicationBean3.setData6("data6");
		
		applicationBean4.setData7("data7");
		applicationBean4.setData8("data8");
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		
		System.out.println(applicationBean1.getData1());
		System.out.println(applicationBean1.getData2());
		System.out.println(applicationBean2.getData3());
		System.out.println(applicationBean2.getData4());
		System.out.println(applicationBean3.getData5());
		System.out.println(applicationBean3.getData6());
		System.out.println(applicationBean4.getData7());
		System.out.println(applicationBean4.getData8());
		
		
		model.addAttribute("bean1", applicationBean1 );
		model.addAttribute("bean2", applicationBean2 );
		model.addAttribute("bean3", applicationBean3 );
		model.addAttribute("bean4", applicationBean4 );
		return "result1";
	}
	
	
	
}
