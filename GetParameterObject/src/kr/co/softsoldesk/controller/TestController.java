package kr.co.softsoldesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.softsoldesk.beans.DataBean;
import kr.co.softsoldesk.beans.DataBean2;



@Controller
public class TestController {

	
	/*
	 * @GetMapping("/test1") public String Test1_Get(@RequestParam Map<String,
	 * String> map, @RequestParam List<String> data3) {
	 * 
	 * 
	 * String data1 = map.get("data1"); String data2 = map.get("data2"); String
	 * data33 = map.get("data3"); System.out.println("map1 :" + data1 );
	 * System.out.println("map2 :" + data2 ); System.out.println("map33 :" +
	 * data33);
	 * 
	 * for(String tmp : data3) { System.out.println("str : " +tmp); } return
	 * "Result";
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/test2") //data1=100, data2=200, data3[]=300,400
	 * //@ModelAttribute어노테이션을 이용하여 객체생성을 할 수 있다. public String test(@ModelAttribute
	 * DataBean bean1) { int data1 = bean1.getData1(); int data2 = bean1.getData2();
	 * int data3[] = bean1.getData3();
	 * 
	 * System.out.println("data1 : " +data1); System.out.println("data2 : " +data2);
	 * 
	 * for (int tmp : data3) { System.out.printf("data3 %d\n", tmp); } return
	 * "Result"; }
	 */
	
	@GetMapping("test2")
	public String test2(@ModelAttribute DataBean bean1, @ModelAttribute DataBean2 bean2) {
		int data1 = bean1.getData1();
		int data2 = bean1.getData2();
		int data3[] = bean1.getData3();
		
		int data2_1 = bean2.getData1();
		int data2_2 = bean2.getData2();
		
		System.out.println("--------------------");
		System.out.println("DataBean's data1 : " +data1);
		System.out.println("DataBean's data2 : " +data2);
		
		for(int tmp : data3) {
		System.out.println("DataBean's data3 : " +tmp);
		}
		
		System.out.println("---------------------");
		System.out.println("DataBean2's data1 " + data2_1);
		System.out.println("DataBean2's data2 " + data2_2);
		return "Result";
	}
}
