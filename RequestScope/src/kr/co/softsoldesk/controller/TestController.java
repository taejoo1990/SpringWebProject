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

	//redirect는 뷰단자체가 바뀌기 떄문에, 데이터의 생명주기가 끝나게 된다
	//forward는 뷰단이 바뀌지 않고, 서버단에서 처리하기 때문에 데이터를 가지고 갈 수 있다.
	@GetMapping("/test1")
	public String test1(HttpServletRequest req) {
		req.setAttribute("data1", "문자열1");
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
		model.addAttribute("data2", "문자열2");
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
		mv.addObject("data3", "문자열3");
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
	
	//자동주입을 이용.
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
	
	//모델이용
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


