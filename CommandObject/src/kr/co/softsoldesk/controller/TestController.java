package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBean;

@Controller
public class TestController {

	//ModelAttribute�� �̿��� �ڵ����԰�, View�ܿ��� ���.
	//����� ���� �ݵ�� Ŭ�����̸��� ù ���ڸ� �ҹ��ڷ� ��ȯ �� �־�� �Ѵ�.
	@PostMapping("/test1")
	public String Test1_Post(@ModelAttribute DataBean bean) {
		String data1 = bean.getData1();
		String data2 = bean.getData2();
		System.out.printf("data1 : %d\n" ,data1);
		System.out.printf("data2 : %s\n" ,data2);
		return "Test1";
	}
	
	//ModelAttribute�� �̿��� �ڵ����Կ�, ���� �̸��� �����Ͽ� View�� ���
	//
	@PostMapping("/test2")
	public String Test2_Post(@ModelAttribute("DataBean") DataBean bean) {
		String ID = bean.getData1();
		String Password = bean.getData2();
		
		return "Test2";
		
	}
}
