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

//SpringMVCXML������Ʈ�� WebContent/WEB-INF/config/Servlet-context.xml�� ����� ����.
//����
@Configuration
//������̼� Controller�� �����Ǿ� �ִ� Ŭ������ ����ϴ� ������̼�, web XML�� <annotation driven>
@EnableWebMvc
//��Ű������ ��ĵ
@ComponentScan(basePackages = { "kr.co.softsoldesk.config", "kr.co.softsoldesk.controller" })
public class ServletAppContext implements WebMvcConfigurer,HandlerInterceptor {

	// controller�޼���(home())���� return�ϴ� ���ڿ��� ����.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	
	}

	// ����������(�̹���,����,������,js,css) ��� ����
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		//���ͼ��� Ŭ������ ��ü�� �����
		TestInterceptor inter1=new TestInterceptor();
		TestInterceptor2 inter2 = new TestInterceptor2();
		
		//���ͼ��� ���
		InterceptorRegistration reg1=registry.addInterceptor(inter1);
		InterceptorRegistration reg2=registry.addInterceptor(inter2);
		
		
		//���ͼ��� �ּҸ����(���ɻ���)
		reg1.addPathPatterns("/test1");
		reg2.addPathPatterns("/test1");
		
	}
	
	
	

}
