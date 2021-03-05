package kr.co.softsoldesk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//SpringMVCXML프로젝트의 WebContent/WEB-INF/config/Servlet-context.xml의 기능을 구현.
//셋팅
@Configuration
//어노테이션 Controller가 설정되어 있는 클래스를 등록하는 어노테이션, web XML의 <annotation driven>
@EnableWebMvc
//패키지들을 스캔
@ComponentScan(basePackages = { "kr.co.softsoldesk.config", "kr.co.softsoldesk.controller", "kr.co.softsoldesk.beans" })
public class ServletAppContext implements WebMvcConfigurer {

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
}
