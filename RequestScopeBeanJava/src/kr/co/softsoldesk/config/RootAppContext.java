package kr.co.softsoldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;

//������Ʈ �۾��� �����Ǵ� beans�� dao,mapper���� ����ϴ� ��
@Configuration
public class RootAppContext {

	@Bean
	@RequestScope //���ο� ��û�� �߻��ϸ� �ڵ����� �� �޼ҵ尡 ȣ��
	public DataBean1 databean1() {
		return new DataBean1();
	}
	
	@Bean("requestBean2")
	@RequestScope
	public DataBean2 databean2() {
		return new DataBean2();
	}
}
