package kr.co.softsoldesk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor4 implements HandlerInterceptor {
	//controller�� �޼��尡 ȣ��Ǳ� ���� ����
	
	//false�� ��ȯ�ϸ� ��ûó���� �ߴ��� �� �մ�.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor4- prehandler");
		return true;
	}
	
	//controller�� �޼��尡 ȣ���� �� �Ŀ� ����
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor4- posthandler");
	}
	
	//view ó������ �Ϸ�� �� ����
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestInterceptor4- afterCompletion");
	}
}

