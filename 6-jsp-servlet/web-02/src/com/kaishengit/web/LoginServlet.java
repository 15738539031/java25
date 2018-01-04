package com.kaishengit.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//��ȡ�ͻ��˿ؼ�Ԫ�ص�ֵ
		String userName = req.getParameter("userName");
		String password = req.getParameter("pass");

		AccountDao accDao = new AccountDao();
		Account account = accDao.findByName(userName);
		
		if(account != null && password.equals(account.getPassword())) {
			
			List<String> lists = new ArrayList<>();
			lists.add("����");
			lists.add("����");
			lists.add("����");
			
			req.setAttribute("userName", userName);
			req.setAttribute("money", account.getMoney());
			req.setAttribute("lists", lists);
			
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
			
		} else {
			resp.sendRedirect("/login.jsp?error=1001&num=1002");
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		if("tom".equals(userName) && "123123".equals(password)) {
//			System.out.println("��¼�ɹ�");
//			List<String> lists = new ArrayList<>();
//			lists.add("����");
//			lists.add("����");
//			lists.add("����");
//			
//			
//			req.setAttribute("userName", userName);
//			req.setAttribute("money", "10000");
//			req.setAttribute("lists", lists);
//			
//			// ����ת��
//			req.getRequestDispatcher("/home.jsp").forward(req, resp);
////			RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
////			rd.forward(req, resp);
//			
//			
//			
//			// �ض���
//			//resp.sendRedirect("/home.jsp");
//		} else {
//			System.out.println("��¼ʧ��");
//			resp.sendRedirect("/login.jsp?error=1001");
//		}
	
	}
	
	
}
