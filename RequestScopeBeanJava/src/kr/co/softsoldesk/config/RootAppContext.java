package kr.co.softsoldesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;

//프로젝트 작업시 구현되는 beans와 dao,mapper등을 등록하는 곳
@Configuration
public class RootAppContext {

	@Bean
	@RequestScope //새로운 요청이 발생하면 자동으로 이 메소드가 호출
	public DataBean1 databean1() {
		return new DataBean1();
	}
	
	@Bean("requestBean2")
	@RequestScope
	public DataBean2 databean2() {
		return new DataBean2();
	}
}
