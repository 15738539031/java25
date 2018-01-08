package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.BookService;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin != null) {
			req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
		} else {
			//û�е�¼����������ص�¼ҳ��
			resp.sendRedirect("/login");
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		// �������� 
		// 1.post�ύ��������
		req.setCharacterEncoding("UTF-8");
		
		// 2.���ձ���ֵ
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String publish = req.getParameter("publish");
		String isbn = req.getParameter("isbn");
		String num = req.getParameter("num");
		
		BookService service = new BookService();
		try {
			service.addBook(name,author,publish,isbn,num);
			// ��ת�ɹ�ҳ��   
			resp.sendRedirect("/list");
			
		} catch(ServiceException e) {
			// ����ת��
			req.setAttribute("name", name);
			req.setAttribute("author", author);
			req.setAttribute("publish", publish);
			req.setAttribute("isbn", isbn);
			req.setAttribute("num", num);
			req.setAttribute("message", e.getMessage());
			
			req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
		}
		
	}

}
