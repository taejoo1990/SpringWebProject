package kr.co.softsoldesk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.softsoldesk.beans.DataBean1;

@Controller
public class TestController {

	//redirect�� �����ü�� �ٲ�� ������, �������� �����ֱⰡ ������ �ȴ�
	//forward�� ����� �ٲ��� �ʰ�, �����ܿ��� ó���ϱ� ������ �����͸� ������ �� �� �ִ�.
	@GetMapping("/test1")
	public String test1(HttpServletRequest req) {
		req.setAttribute("data1", "���ڿ�1");
		//return "redirect:/result1";
		return "forward:/result1";
	}

	
	@GetMapping("/result1")
	public String result1(HttpServletRequest req) {
		req.getAttribute("data1");
		return "Result";
	}

	//========================================================
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("data2", "���ڿ�2");
		//return "redirect:/result1";
		return "forward:/result2";
	}
	
	/*@GetMapping("/result2")
	public String result(Model model) {
		String tmp = (String)model.getAttribute("data2");
		System.out.println(tmp);
		return "Result";
	}*/
	
	@GetMapping("/result2")
	public String result2(HttpServletRequest req) {
		req.getAttribute("data2");
		return "Result";
	}
	
	//========================================================
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		String viewName="forward:/result3";
		mv.addObject("data3", "���ڿ�3");
		mv.setViewName(viewName);
		//return "redirect:/result1";
		return mv;
	}
	@GetMapping("/result3")
	public ModelAndView result3(ModelAndView mv) {
		mv.getView();
		mv.setViewName("Result");
		//return "redirect:/result1";
		return mv;
	}
	
	/*@GetMapping("/result3")
	public String result3(HttpServletRequest req) {
		req.getAttribute("data3");
		//return "redirect:/result1";
		return "Result";
	}*/
	//===================================================
	
	//�ڵ������� �̿�.
	/*@GetMapping("/test4")
	public String Test4(@ModelAttribute("DataBean1") DataBean1 bean) {
		bean.setData1("1");
		bean.setData2("2");
		return "forward:/result4";
	}*/
	
	/*@GetMapping("/result4")
	public String result4(DataBean1 bean) {
		bean.getData1();
		bean.getData2();
		System.out.println(bean.getData1());
		System.out.println(bean.getData2());
		return "Result";
	}*/
	
	//���̿�
	public String Test4(Model model ) {
		DataBean1 bean = new DataBean1();
		bean.setData1("1");
		bean.setData2("2");
		model.addAttribute("bean",bean);
		return "forward:/result4";
	}
	
	@GetMapping("/result4")
	public String reult4(HttpServletRequest req) {
		DataBean1 bean = (DataBean1)req.getAttribute("bean");
		System.out.println("data1 :" +bean.getData1());
		System.out.println("data1 :" +bean.getData2());
		return "Result";
	}
	
	//================================================
	@GetMapping("/test5")
	public String Test5(@ModelAttribute("DataBean1") DataBean1 bean) {
		bean.setData1("1");
		bean.setData2("2");
		return "forward:/result5";
	}
	
	@GetMapping("/result5")
	public String result4(HttpServletRequest req) {
		DataBean1 bean = (DataBean1)req.getAttribute("DataBean1");
		System.out.println(bean.getData1());
		System.out.println(bean.getData2());		
		return "Result";
	}

}


