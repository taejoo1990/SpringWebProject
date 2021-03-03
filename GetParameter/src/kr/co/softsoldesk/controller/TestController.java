package kr.co.softsoldesk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String Test1_Get(HttpServletRequest req, HttpServletResponse res) {
		String data1 = req.getParameter("data1");
		String data2 = req.getParameter("data2");
		String[] data3 = req.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for (String tmp : data3) {
			System.out.println("data3 : " + tmp);
		}
		return "Result";
	}

	@PostMapping("/test2")
	public String Test2_Post(HttpServletRequest req, HttpServletResponse res) {
		String data1 = req.getParameter("data1");
		String data2 = req.getParameter("data2");
		String[] data3 = req.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);

		if (data3 == null) {
			System.out.println("선택값이 없음");
		} else {
			for (String tmp : data3) {
				System.out.println("data3 : " + tmp);
			}
		}

		return "Result";
	}
	@GetMapping("/test3")
	public String test3(WebRequest req) {
		String data1 = req.getParameter("data1");
		String data2 = req.getParameter("data2");
		String[] data3 = req.getParameterValues("data3");
		
		return "Result";
	}
	
	
	//@pathvarialbe
	//순서대로만 가지고 온다는 단점이 있다.
	//변수방 이름으로 EL표기법으로 뷰단에 표기가 가능하다. 
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String Test4(@PathVariable int data1,@PathVariable int data2,@PathVariable int data3) {
		
		int sum = data1+data2+data3;
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		System.out.println("sum : " + sum);
		return "Test";
	}
	
	
	//RequestPram
	//pathVarialble과 비슷하지만 순서와 상관없이 value값을 지정하여 파라미터를 받을 수 있다.
	//예외처리에 대한 기능을 지원한다.
	@GetMapping("/test5")
	public String Test5(@RequestParam int data1, @RequestParam int data2, @RequestParam int[] data3) {
	
	System.out.println("data1 : " + data1);
	System.out.println("data2 : " + data2);
	
	for(int tmp : data3) {
		System.out.println("data3 : " +tmp);
	}
	
	return "Test";
	}
	
	
	@GetMapping("/test6")
	public String Test6(@RequestParam(value="data1") int Num1,@RequestParam(value="data3") int[] Num3) {
		System.out.println("data1 : " + Num1);
	
		
		for(int tmp : Num3) {
			System.out.println("data3 : " +tmp);
		}
		
		return "Test";
	}
	
	//RequestParam의 기능
	//requred : 필수값에대한 표현. 파라미터값이 넘어오지 않더라도 null값으로 처리 ,다만 자동형변환 해주지 못하기 때문에 반드시 String으로 받아야함.
	//defaultValue : null값 경우의 표현. 파라미터값이 넘어 오지 않는다면 지정한 값으로 처리.
	@GetMapping("/test7")
	public String Test7(@RequestParam(value="data1") int Num1, 
						@RequestParam(value="data2", required = false) String Num2,
						@RequestParam(value="data3", defaultValue = "0") int Num3) {
		System.out.println(Num1);
		System.out.println(Num2);
		System.out.println(Num3);
		
		return "Result";
	}
}
