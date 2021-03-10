package kr.co.softsoldesk.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBean1;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data(@ModelAttribute("DataBean1") DataBean1 dataBean1) {
		String view  = "Input_data";
		return view;
	}
	
	@PostMapping("/input_pro")
	public String Input_Pro(@Valid @ModelAttribute("DataBean1") DataBean1 dataBean1, BindingResult result) {
	String view="Input_success";
	String reWrite="Input_data";
	
	if(result.hasErrors()) {
		return reWrite;
	}
	return view;
}
}
