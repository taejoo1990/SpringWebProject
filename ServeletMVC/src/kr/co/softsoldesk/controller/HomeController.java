package kr.co.softsoldesk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.softsoldesk.model.Test2Service;

@WebServlet("*.mvc") // 확장자가 mvc인 모든 주소를 불러올 수 있음. 다수이름의 주소가 접근이 가능하도록 *을 줌.ㄷㅇ
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("HomeContorller");
		String url = request.getRequestURI();
		// System.out.println("url");
		// 모델에서의 코드는 가독과 유지보수가 어려워서 만들지 않음.
		// 파라미터 데이터 추출

		String viewName = null;
		if (url.contains("main.mvc")) {
			// System.out.println("main 요청");
			viewName = "Main.jsp";

		} else if (url.contains("test1.mvc")) {
			viewName = "Test1.jsp";
			
			//파라미터를 받아서 마이너스값을 넘겨줌
			//String str1 = request.getParameter("data1");
			//String str2 = request.getParameter("data2");
			//int i1 = Integer.parseInt(str1);
			//int i2 = Integer.parseInt(str2);
			
			//연산을 model에 있는 메서드를 통해 가져옴
			int result = Test2Service.minus(request);
			request.setAttribute("result", result);

		} else if (url.contains("test2.mvc")) {
			viewName = "Test2.jsp";
			
			//String str1 = request.getParameter("data1");
			//String str2 = request.getParameter("data2");
			//int i1 = Integer.parseInt(str1);
			//int i2 = Integer.parseInt(str2);
			//int result = i1 + i2;
			int result = Test2Service.minus(request);
			request.setAttribute("result", result);
		
		}

		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
