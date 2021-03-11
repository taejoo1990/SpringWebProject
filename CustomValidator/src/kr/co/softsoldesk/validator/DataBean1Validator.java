package kr.co.softsoldesk.validator;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.softsoldesk.beans.DataBean1;

public class DataBean1Validator implements Validator{
    //유효성이 가능한 클래스인지 확인해주는 메소드 
	@Override
	public boolean supports(Class<?> clazz) {
		return DataBean1.class.isAssignableFrom(clazz);
	}
    //유효성 검사에 위배되었을때 에러에 대한 메세지를 저장해주는 메소드
	//Object target :new DataBean1
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");
		
		//형변환
		DataBean1 bean1=(DataBean1)target;
		
		//데이터 가져오기
		String data2=bean1.getData2();
		String data3=bean1.getData3();
		
		if(data2.length()>10) {
			errors.rejectValue("data2", "error4");
		}
		
		if(data3.contains("@")==false) {
			errors.rejectValue("data3", "error5");
		}

		
	}

	
}
