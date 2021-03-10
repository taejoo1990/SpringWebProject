package kr.co.softsoldesk.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBean1;

@Controller
public class TestController {

	
	@GetMapping("/input_data")
	public String Input_data() {
		String view="Input_data";
		return view;
	}
	//BindingResult : 유효성검사에 위배여부의 결과를 저장. 결과값은 Errors에 담아 둠
	@PostMapping("/input_pro")
	public String Input_pro(@Valid @ModelAttribute("DataBean1") DataBean1 bean1, BindingResult result) {
		String view="Input_success";
		System.out.println("Data1 : " +bean1.getData1());
		System.out.printf("Data1 : %s\n", bean1.getData2());
		
		System.out.printf("Binding : %s\n", result );
		bean1.getData2();
		
		//유효성 검사 위배시
				if(result.hasErrors()) {//true
					for(ObjectError obj: result.getAllErrors()) {
						System.out.printf("메세지 : %s\n", obj.getDefaultMessage()); //메세지 배열의 0번째것(=디폴트?)만 보여줌 
						System.out.printf("code : %s\n", obj.getCode());
						System.out.printf("object name : %s\n", obj.getObjectName());
						System.out.println("-----------------------");
						
						String[] codes =obj.getCodes(); //모든 에러 담음 
						for(String c1: codes) {
							System.out.println(c1);
						}
						if(codes[0].equals("Size.dataBean1.data1")) {
							//추후 구현부 
							System.out.println("[구현] data1은 2~10글자를 입력하세요.");
						}if(codes[0].equals("Max.dataBean1.data2")) {
							System.out.println("[구현] data2는 100이하의 값만 입력할 수 있습니다. ");
						}
						System.out.println("————————————");
					} 
					//다시 입력할 수 있도록 되돌아감 (되돌아갈때 맞는 값은 고정시키도록…나중에 한다고 함) 
					return "input_data";
				}

		return view;
	}
}
