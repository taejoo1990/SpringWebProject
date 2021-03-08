package kr.co.softsoldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;

//������Ʈ �۾��� �����Ǵ� beans�� dao,mapper���� ����ϴ� ��
@Configuration
public class RootAppContext {

	
	@Bean
	@SessionScope
	public DataBean1 bean1() {
		return new DataBean1();
	}
	
	@Bean("sessionBean2")
	@SessionScope
	public DataBean2 bean2() {
		return new DataBean2();
	}
}
