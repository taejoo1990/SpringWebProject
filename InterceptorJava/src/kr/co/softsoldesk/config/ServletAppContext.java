package kr.co.softsoldesk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.softsoldesk.interceptor.TestInterceptor;
import kr.co.softsoldesk.interceptor.TestInterceptor2;

//SpringMVCXML프로젝트의 WebContent/WEB-INF/config/Servlet-context.xml의 기능을 구현.
//셋팅
@Configuration
//어노테이션 Controller가 설정되어 있는 클래스를 등록하는 어노테이션, web XML의 <annotation driven>
@EnableWebMvc
//패키지들을 스캔
@ComponentScan(basePackages = { "kr.co.softsoldesk.config", "kr.co.softsoldesk.controller" })
public class ServletAppContext implements WebMvcConfigurer,HandlerInterceptor {

	// controller메서드(home())에서 return하는 문자열을 정리.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	
	}

	// 정적데이터(이미지,사운드,동영상,js,css) 경로 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		//인터셉터 클래스의 객체를 만들기
		TestInterceptor inter1=new TestInterceptor();
		TestInterceptor2 inter2 = new TestInterceptor2();
		
		//인터셉터 등록
		InterceptorRegistration reg1=registry.addInterceptor(inter1);
		InterceptorRegistration reg2=registry.addInterceptor(inter2);
		
		
		//인터셉터 주소만들기(관심사등록)
		reg1.addPathPatterns("/test1");
		reg2.addPathPatterns("/test1");
		
	}
	
	
	

}
