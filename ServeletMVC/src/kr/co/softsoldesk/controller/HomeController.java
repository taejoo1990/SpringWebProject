package kr.co.softsoldesk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.softsoldesk.model.Test2Service;

@WebServlet("*.mvc") // Ȯ���ڰ� mvc�� ��� �ּҸ� �ҷ��� �� ����. �ټ��̸��� �ּҰ� ������ �����ϵ��� *�� ��.����
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
		// �𵨿����� �ڵ�� ������ ���������� ������� ������ ����.
		// �Ķ���� ������ ����

		String viewName = null;
		if (url.contains("main.mvc")) {
			// System.out.println("main ��û");
			viewName = "Main.jsp";

		} else if (url.contains("test1.mvc")) {
			viewName = "Test1.jsp";
			
			//�Ķ���͸� �޾Ƽ� ���̳ʽ����� �Ѱ���
			//String str1 = request.getParameter("data1");
			//String str2 = request.getParameter("data2");
			//int i1 = Integer.parseInt(str1);
			//int i2 = Integer.parseInt(str2);
			
			//������ model�� �ִ� �޼��带 ���� ������
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
