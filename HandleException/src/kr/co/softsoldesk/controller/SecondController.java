package kr.co.softsoldesk.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

	@GetMapping("/test2")
	public String test2() {
		String view = "Test2";
		
		ArrayList<String> list=null;
		list.add("���ڿ�");
		return view;
	}
	
	
	
	//�̰��� �ִ� ��Ʈ�ѷ��� ����. ������ ����ϸ� ��� ��Ʈ�ѷ��� ���밡��.
	
	/*@ExceptionHandler(NullPointerException.class)
	public String Exception() {
		String error2 = "Error2";
		return error2;
	}*/
	
}
