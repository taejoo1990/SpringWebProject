package kr.co.softsoldesk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;
import kr.co.softsoldesk.beans.DataBean3;
import kr.co.softsoldesk.beans.DataBean4;

@Controller
public class TestControeller {
	
	//xml사용시 자동으로 객체를 호출하여 생성자를 생성하기 때문에, lazy값을 반드시 줘야함
	@Autowired
	@Lazy
	DataBean1 requestBean1;
	
	@Resource(name ="requestBean2")
	@Lazy
	DataBean2 requestBean2;
	
	//컴포넌트로 주입
	@Autowired
	@Lazy
	DataBean3 requestBean3;
	
	//컴포넌트 이름으로 주입
	@Resource(name = "requestBean4")
	@Lazy
	DataBean4 requestBean4;
	
	@GetMapping("/test1")
	public String Test1_Get() {
		requestBean1.setData1("문자1");
		requestBean1.setData2("문자2");
		requestBean2.setData3("문자3");
		requestBean2.setData4("문자4");
		requestBean3.setData5("문자5");
		requestBean3.setData6("문자6");
		requestBean4.setData7("문자7");
		requestBean4.setData8("문자8");
	return "forward:/result1"; //새로운 요청이 발생하는 것이 아니기 때문에 DataBean1의 주입이 발생하지 않음
	}
	
	@GetMapping("/result1")
	public String Result1(Model model) {
		System.out.println(requestBean1.getData1());
		System.out.println(requestBean1.getData2());
		System.out.println(requestBean2.getData3());
		System.out.println(requestBean2.getData4());
		System.out.println(requestBean3.getData5());
		System.out.println(requestBean3.getData6());
		System.out.println(requestBean4.getData7());
		System.out.println(requestBean4.getData8());
		
		model.addAttribute("requestBean1",requestBean1);
		model.addAttribute(requestBean3);
		model.addAttribute(requestBean4);
		//타개체가 더 있어도, 등록하지 않아도 됨.
		return "Test1";
	}
	
	

}
