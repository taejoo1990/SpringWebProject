package kr.co.softsoldesk.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//��� ��Ʈ�ѷ����� advice�� �ִ� Ŭ����
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	

	@ExceptionHandler(NullPointerException.class)
	public String Exception() {
		String error2 = "Error2";
		return error2;
	}
	

}
