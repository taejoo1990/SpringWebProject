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

	//�� �����ϰ� ����� �� ������ Ȯ�强�� �������� �͵� ����.
	
	//SpringMVCXML������Ʈ�� web.xml�ȿ� �ִ� <servlet>�±� �����ο� ���� ����� ����. 
	//servlet-context.xml������ ��ɰ�, �� ������ ã���� ��ġ�� ��������.
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
	AnnotationConfigWebApplicationContext servletAppContext= new AnnotationConfigWebApplicationContext();
	servletAppContext.register(ServletAppContext.class);
	
	// ��û ������ �м��ؼ� ��Ʈ�ѷ��� �����ϴ� ������ �����Ѵ�.
	DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
	// �Ű������� ����� servletContext��ü�� �̿��Ͽ� servlet�� �߰�
	ServletRegistration.Dynamic servlet=servletContext.addServlet("dispacher", dispatcherServlet);
	
	//�ΰ�����
	servlet.setLoadOnStartup(1); //�߰� �� ���� ���� �ε��Ѵ�.
	servlet.addMapping("/");//��� ��ο� �����Ѵ�.
	
	//web.xml���� <context-param>�����Ǻ��� ����
	//Bean�� ������ xml������ �����Ѵ�
	AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
	rootAppContext.register(RootAppContext.class);
	
	//web.xml���� <listner>�����ο� ����
	ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
	servletContext.addListener(listener);
	
	
	FilterRegistration.Dynamic filter=servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
	filter.setInitParameter("encoding", "UTF-8");
	
	filter.addMappingForServletNames(null, false, "dispatcher");
	
			
	}

}
