package kr.co.softsoldesk.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String input_data(DataBean1 dataBean1) {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {//유효성 검사에 실패한것이 있다면 input_data 실행
			return "input_data";
		}
		
		return "input_success";
	}

}
