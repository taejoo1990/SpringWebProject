package kr.co.softsoldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//(servlet-context에서 <annotation-driven/>와 같음)
@Configuration
//Controller어노테이션이 설정되어있는 클래스를 등록하는 어노테이션
@EnableWebMvc
//스캔할 패키지 등록
@ComponentScan("kr.co.softsoldesk.controller")
public class ServletAppContext implements WebMvcConfigurer{
	
	//controller메서드(home())에서 반환하는 문자열 앞(경로),뒤(확장자)에 붙을 경로
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	//정적데이터(이미지,사운드,동영상,js,css) 경로 설전
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//유효성 검사 properties 등록
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res=new ReloadableResourceBundleMessageSource();
		res.setBasename("/WEB-INF/properties/error_message");
		return res;
	}

}
