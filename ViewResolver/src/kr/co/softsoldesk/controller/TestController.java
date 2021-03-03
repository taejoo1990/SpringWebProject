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
		//data���
		
		//HttpServletRequest�� setAttribute�� ����ϰ� getAttribute�� jsp�� ����
		req.setAttribute("data1", 300);
		req.setAttribute("data2", 400);

		return "Test2";
	}
	

	@GetMapping("/test3")
	public String Test3_Get(Model model) {
		//Model��ü�� Add�ϸ� Request��ü�� ����.
		model.addAttribute("data1", 300);
		model.addAttribute("data2", 400);
		return "Test3";
	}
	@GetMapping("/test4")
	public ModelAndView Test4_Get(ModelAndView mv) {
		mv.addObject("data1", 100);
		mv.addObject("data2", 200);
		///ViewName ����, view�����̶� view���� �̸��̹Ƿ�, ���� jsp�� ��ġ�� �����ϰ� �ȴ�.
		mv.setViewName("Test4");
		return mv;
	}
}
