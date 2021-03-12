package kr.co.softsoldesk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{

	//������� ���ͼ�Ʈ
	//controller�� �޼��尡 ȣ��Ǳ� ���� ����
	
	//false�� ��ȯ�ϸ� ��ûó���� �ߴ��� �� �մ�.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor1- prehandler");
		return false;
	}
	
	//controller�� �޼��尡 ȣ���� �� �Ŀ� ����
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor1- posthandler");
	}
	
	//view ó������ �Ϸ�� �� ����
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestInterceptor1- afterCompletion");
	}
}