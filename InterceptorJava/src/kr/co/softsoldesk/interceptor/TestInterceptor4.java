package kr.co.softsoldesk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor4 implements HandlerInterceptor {
	//controller의 메서드가 호출되기 전에 수행
	
	//false를 반환하면 요청처리를 중단할 수 잇다.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor4- prehandler");
		return true;
	}
	
	//controller의 메서드가 호출이 된 후에 수행
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor4- posthandler");
	}
	
	//view 처리까지 완료된 후 수행
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestInterceptor4- afterCompletion");
	}
}

