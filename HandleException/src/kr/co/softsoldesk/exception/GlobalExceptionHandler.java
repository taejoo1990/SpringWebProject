package kr.co.softsoldesk.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//모든 컨트롤러에게 advice를 주는 클래스
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	

	@ExceptionHandler(NullPointerException.class)
	public String Exception() {
		String error2 = "Error2";
		return error2;
	}
	

}
