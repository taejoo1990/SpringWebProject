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
import kr.co.softsoldesk.interceptor.TestInterceptor3;
import kr.co.softsoldesk.interceptor.TestInterceptor4;
import kr.co.softsoldesk.interceptor.TestInterceptor5;
import kr.co.softsoldesk.interceptor.TestInterceptor6;
import kr.co.softsoldesk.interceptor.TestInterceptor7;
import kr.co.softsoldesk.interceptor.TestInterceptor8;

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
		TestInterceptor3 inter3 = new TestInterceptor3();
		TestInterceptor4 inter4 = new TestInterceptor4();
		TestInterceptor5 inter5 = new TestInterceptor5();
		TestInterceptor6 inter6 = new TestInterceptor6();
		TestInterceptor7 inter7 = new TestInterceptor7();
		TestInterceptor8 inter8 = new TestInterceptor8();
		
		//���ͼ��� ���
		InterceptorRegistration reg1=registry.addInterceptor(inter1);
		InterceptorRegistration reg2=registry.addInterceptor(inter2);
		InterceptorRegistration reg3= registry.addInterceptor(inter3);
		InterceptorRegistration reg4= registry.addInterceptor(inter4);
		InterceptorRegistration reg5= registry.addInterceptor(inter5);
		InterceptorRegistration reg6= registry.addInterceptor(inter6);
		InterceptorRegistration reg7= registry.addInterceptor(inter7);
		InterceptorRegistration reg8= registry.addInterceptor(inter8);
		
		//���ͼ��� �ּҸ����(���ɻ���)
		reg1.addPathPatterns("/test1");
		reg2.addPathPatterns("/test1");
		reg3.addPathPatterns("/test2");
		reg4.addPathPatterns("/test1","/test2");
		reg5.addPathPatterns("/sub1/test3","/sub1/test4");
		reg6.addPathPatterns("/*");
		reg7.addPathPatterns("/sub1/*");
		reg8.addPathPatterns("/**");
		//���ͼ��� ���ɻ� ��, �Ϻ� ����
		reg8.excludePathPatterns("/*");
	}
	
	
	

}
