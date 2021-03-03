package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBean;

@Controller
public class TestController {

	//ModelAttribute를 이용한 자동주입과, View단에서 출력.
	//출력할 때는 반드시 클래스이름의 첫 글자를 소문자로 변환 해 주어야 한다.
	@PostMapping("/test1")
	public String Test1_Post(@ModelAttribute DataBean bean) {
		String data1 = bean.getData1();
		String data2 = bean.getData2();
		System.out.printf("data1 : %d\n" ,data1);
		System.out.printf("data2 : %s\n" ,data2);
		return "Test1";
	}
	
	//ModelAttribute를 이용한 자동주입에, 모델의 이름을 지정하여 View에 출력
	//
	@PostMapping("/test2")
	public String Test2_Post(@ModelAttribute("DataBean") DataBean bean) {
		String ID = bean.getData1();
		String Password = bean.getData2();
		
		return "Test2";
		
	}
}
