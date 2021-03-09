package kr.co.softsoldesk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//�������� ����
//@PropertySources({values="/WEB-INF/properties/data.properties","/WEB-INF/properties/data2.properties"})
//�������� ��������
@PropertySource("/WEB-INF/properties/data.properties")
@PropertySource("/WEB-INF/properties/data2.properties")
public class TestController {

	@Value("${aaa.a1}")
	private int a1;
	
	@Value("${aaa.a2}")
	private String a2;
	
	@Value("${bbb.b1}")
	private int b1;
	
	@Value("${bbb.b2}")
	private String b2;
	
	@Value("${ccc.c1}")
	private int c1;
	
	@Value("${ccc.c2}")
	private String c2;
	
	@Value("${ddd.d1}")
	private int d1;
	
	@Value("${ddd.d2}")
	private String d2;
	
	@GetMapping("/test")
	public String test1() {
		System.out.printf("aaa.a1 : %d\n", a1);
		System.out.printf("aaa.a2 : %s\n", a2);
		
		System.out.printf("bbb.b1 : %d\n", b1);
		System.out.printf("bbb.b2 : %s\n", b2);
		
		System.out.printf("ccc.c1 : %d\n", c1);
		System.out.printf("ccc.c2 : %s\n", c2);
		
		System.out.printf("ddd.d1 : %d\n", d1);
		System.out.printf("ddd.d2 : %s\n", d2);
		return "Test1";
	}
}
