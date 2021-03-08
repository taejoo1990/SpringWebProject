package kr.co.softsoldesk.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringConfigClass implements WebApplicationInitializer{

	//더 간단하게 사용할 수 있으나 확장성이 떨어지는 것도 있음.
	
	//SpringMVCXML프로젝트의 web.xml안에 있는 <servlet>태그 구현부와 같은 기능을 수행. 
	//servlet-context.xml폴더의 기능과, 그 폴더를 찾도록 위치를 지정해줌.
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
	AnnotationConfigWebApplicationContext servletAppContext= new AnnotationConfigWebApplicationContext();
	servletAppContext.register(ServletAppContext.class);
	
	// 요청 정보를 분석해서 컨트롤러를 선택하는 서블릿을 지정한다.
	DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
	// 매개변수로 선언된 servletContext객체를 이용하여 servlet에 추가
	ServletRegistration.Dynamic servlet=servletContext.addServlet("dispacher", dispatcherServlet);
	
	//부가설정
	servlet.setLoadOnStartup(1); //추가 후 제일 먼저 로딩한다.
	servlet.addMapping("/");//모든 경로에 적용한다.
	
	//web.xml에서 <context-param>구현의부의 역할
	//Bean을 정의할 xml파일을 지원한다
	AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
	rootAppContext.register(RootAppContext.class);
	
	//web.xml에서 <listner>구현부와 같음
	ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
	servletContext.addListener(listener);
	
	
	FilterRegistration.Dynamic filter=servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
	filter.setInitParameter("encoding", "UTF-8");
	
	filter.addMappingForServletNames(null, false, "dispatcher");
	
			
	}

}
