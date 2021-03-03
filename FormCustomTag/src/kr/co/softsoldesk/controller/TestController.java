package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBeans;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String Test1_Get() {
		return "Test1";
	}
	
	@GetMapping("test1_get")
	//CommandObject
	public String test(@ModelAttribute("DataBeans") DataBeans bean) {
		bean.setName("ted");
		bean.setId("taejoo1990");
		bean.setPw("12345");
		bean.setAddrNum("133-111");
		bean.setAddr1("����");
		bean.setAddr2("����");
		return "Test1_Get";
	}
	
	//���� �̸��� �������� �����Ÿ�, ModelAttribute������̼��� ������ �� �ִ�.
	@GetMapping("test2")
	public String Test2_Get(DataBeans bean) {
		bean.setName("ted");
		bean.setId("taejoo1990");
		bean.setPw("12345");
		bean.setAddrNum("133-111");
		bean.setAddr1("����");
		bean.setAddr2("����");
		return "Test2";
	}
	
	@PostMapping("/result")
	public String Result_Post(@ModelAttribute("DataBeans") DataBeans bean) {
		return "Result";
		
	}
	@GetMapping("/test3")
	public String test3(@ModelAttribute("DataBeans") DataBeans bean) {
		bean.setName("ted");
		bean.setId("taejoo1990");
		bean.setPw("12345");
		bean.setAddrNum("133-111");
		bean.setAddr1("����");
		bean.setAddr2("����");
		return "Test3";
		
	}
	@GetMapping("/test4")
	public String test3(Model model) {
		DataBeans bean = new DataBeans();
		bean.setName("ted");
		bean.setId("taejoo1990");
		bean.setPw("12345");
		bean.setAddrNum("133-111");
		bean.setAddr1("����");
		bean.setAddr2("����");
		model.addAttribute(bean);
		
		return "Test4";
	}
	
}
