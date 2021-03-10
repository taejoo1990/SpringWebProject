package kr.co.softsoldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//SpringMVCXML������Ʈ�� WebContent/WEB-INF/config/Servlet-context.xml�� ����� ����.
//����
@Configuration
//������̼� Controller�� �����Ǿ� �ִ� Ŭ������ ����ϴ� ������̼�, web XML�� <annotation driven>
@EnableWebMvc
//��Ű������ ��ĵ
@ComponentScan(basePackages = { "kr.co.softsoldesk.config", "kr.co.softsoldesk.controller" })
public class ServletAppContext implements WebMvcConfigurer {

	//properties������ Messge�� ���
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
	ReloadableResourceBundleMessageSource res=new ReloadableResourceBundleMessageSource();
	
	//���Ȯ���� �� �ᵵ ��
	//res.setBasename("WebContent/WEB-INF/properties/data1");
	res.setBasenames("/WEB-INF/properties/data1","/WEB-INF/properties/errormessage");
	return res;

	}
	
	
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
}
