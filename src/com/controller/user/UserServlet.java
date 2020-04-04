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
    //创建一个service对象
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
		//接收页面数据
		String name=request.getParameter("username");
		String psw=request.getParameter("password");
		String code=request.getParameter("code");
		//获取后台验证码
		String new_code=(String)request.getSession().getAttribute("yzm");
		//判断验证码输入是否相等
		if(new_code.equals(code)) {
			//调用验证密码 账户是否匹配的方法
			isPass=us.isValidation(name, psw);
			if (isPass) {
				//将登录用户名存到作用域
				request.getSession().setAttribute("name", name);
				//页面跳转
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
