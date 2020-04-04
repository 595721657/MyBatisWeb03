package com.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.user.UserService;
import com.service.user.impl.UserServiceImpl;

/**
 * Servlet implementation class User
 */
@WebServlet("/Login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //����һ��service����
	private UserService us=new UserServiceImpl();
	private boolean isPass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ҳ������
		String name=request.getParameter("username");
		String psw=request.getParameter("password");
		String code=request.getParameter("code");
		//��ȡ��̨��֤��
		String new_code=(String)request.getSession().getAttribute("yzm");
		//�ж���֤�������Ƿ����
		if(new_code.equals(code)) {
			//������֤���� �˻��Ƿ�ƥ��ķ���
			isPass=us.isValidation(name, psw);
			if (isPass) {
				//����¼�û����浽������
				request.getSession().setAttribute("name", name);
				//ҳ����ת
				request.getRequestDispatcher("Index?op=show").forward(request, response);
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
