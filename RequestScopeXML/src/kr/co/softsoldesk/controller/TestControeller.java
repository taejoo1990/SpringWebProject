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
	
	//xml���� �ڵ����� ��ü�� ȣ���Ͽ� �����ڸ� �����ϱ� ������, lazy���� �ݵ�� �����
	@Autowired
	@Lazy
	DataBean1 requestBean1;
	
	@Resource(name ="requestBean2")
	@Lazy
	DataBean2 requestBean2;
	
	//������Ʈ�� ����
	@Autowired
	@Lazy
	DataBean3 requestBean3;
	
	//������Ʈ �̸����� ����
	@Resource(name = "requestBean4")
	@Lazy
	DataBean4 requestBean4;
	
	@GetMapping("/test1")
	public String Test1_Get() {
		requestBean1.setData1("����1");
		requestBean1.setData2("����2");
		requestBean2.setData3("����3");
		requestBean2.setData4("����4");
		requestBean3.setData5("����5");
		requestBean3.setData6("����6");
		requestBean4.setData7("����7");
		requestBean4.setData8("����8");
	return "forward:/result1"; //���ο� ��û�� �߻��ϴ� ���� �ƴϱ� ������ DataBean1�� ������ �߻����� ����
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
		//Ÿ��ü�� �� �־, ������� �ʾƵ� ��.
		return "Test1";
	}
	
	

}
