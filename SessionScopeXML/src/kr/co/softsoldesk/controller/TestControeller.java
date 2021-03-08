package kr.co.softsoldesk.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;
import kr.co.softsoldesk.beans.DataBean3;
import kr.co.softsoldesk.beans.DataBean4;

@Controller
public class TestControeller {

	@Autowired
	@Lazy
	DataBean1 sessionBean1;
	
	@Resource(name="sessionBean2")
	@Lazy
	DataBean2 sessionBean2;
	
	@Autowired
	@Lazy
	DataBean3 sessionBean3;

	@Resource(name="sessionBean4")
	@Lazy
	DataBean4 sessionBean4;
	
	@GetMapping("/test1")
	@Lazy
	public String Test1() {
		String view= "Test1";
		sessionBean1.setData1("data1");
		sessionBean1.setData2("data2");
		
		sessionBean2.setData3("data3");
		sessionBean2.setData4("data4");
		
		sessionBean3.setData5("data5");
		sessionBean3.setData6("data6");
		
		sessionBean4.setData7("data7");
		sessionBean4.setData8("data8");
		
		return view;
	}
	@GetMapping("/result1")
	public String Result1(Model model) {
		String data1=sessionBean1.getData1();
		String data2=sessionBean1.getData2();
		String data3=sessionBean2.getData3();
		String data4=sessionBean2.getData4();
		
		String data5=sessionBean3.getData5();
		String data6=sessionBean3.getData6();
		String data7=sessionBean4.getData7();
		String data8=sessionBean4.getData8();
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		System.out.println(data5);
		System.out.println(data6);
		System.out.println(data7);
		System.out.println(data8);
		//xml은 생략가능.
		model.addAttribute("sessionBean1",sessionBean1);
		model.addAttribute("sessionBean2",sessionBean2);
		model.addAttribute("sessionBean3",sessionBean3);
		model.addAttribute("sessionBean4",sessionBean4);
		String view= "Result1";
		return view;
		
		
	}
}
