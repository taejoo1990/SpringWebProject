import javax.servlet.http.HttpServletResponse;

public class Remark {

	/*
	 * HttpServletRequest : 요청 정보의 객체타입을 자동으로 맞추며 소멸될 때까지 상태를 유지하는 기능
	 * -setAttribute() : 메소드로 등록하고 -getAttribute() : 메소드로 데이터 추출하여 view로 보냄
	 * 
	 * HttpServletResponse :
	 */
	
	/*WebRequest request : HttpServletRequest보다 추가된 기능
	HttpServletRequest의 요청정보를 거의 대부분 그대로 갖고 있는 
	API로 Servlet API의 종속적이지 않은 타입
	원래는 서블릿과 포틀릿(포틀릿은 복합페이지의 컨텍스트내에 결집되기 위해 특별히 고안된 웹컴포넌트이다) 
              환경 양쪽 모두 사용할 수 있도록 만들어진 타입이다.*/

}
