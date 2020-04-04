package com.controller.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.service.book.BookService;
import com.service.book.impl.BookServiceImpl;

@WebServlet("/Index")
public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6066954839066861622L;
    private BookService bs=new BookServiceImpl();
    private boolean isPass;
    private Book book=new Book();
    private SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("show".equals(op)) {
			//调用展示的方法
			showBook(req,resp);
		}else if("del".equals(op)) {
			//调用删除的方法
			delBook(req,resp);
		}else if("find".equals(op)) {
			//调用通过id查询数据的方法
			findBook(req,resp);
		}else if("add".equals(op)) {
			//调用增加的方法
			addBook(req,resp);
		}
		else if("update".equals(op)) {
			//调用修改的方法
			updateBook(req,resp);
		}
	}
	//修改数据的方法
    private void updateBook(HttpServletRequest req, HttpServletResponse resp) {
    	try {
			req.setCharacterEncoding("UTF-8");
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String author=req.getParameter("author");
			String publish=req.getParameter("publish");
			String date=req.getParameter("publishdate");
			int page=Integer.parseInt(req.getParameter("page"));
			double price=Double.parseDouble(req.getParameter("price"));
			String content=req.getParameter("content");
		    book=new Book(id, name, author, publish, format.parse(date), page, price, content);
		    isPass=bs.updateBook(book);
		    if(isPass) {
		    	resp.sendRedirect("Index?op=show");
		    }else {
		    	resp.sendRedirect("Index?op=find&id="+id);
		    }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	//展示所有数据
	@SuppressWarnings("unchecked")
	private void showBook(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//获取页码
			String pageIndex=req.getParameter("pageIndex");
			int currpage=1; 
			//创建一个分页对象
			com.entity.Pager pg=new com.entity.Pager();
			//获取数据总条数
			int totalCount=bs.getCount();
			pg.setTotalCount(totalCount);
			if(pageIndex==null || "".equals(pageIndex)) {
				currpage=1;
			}else {
				int num=Integer.parseInt(pageIndex);
				if(num<=0) {
					currpage=1;
				}else if(num>=pg.getTotalPages()) {
					currpage=pg.getTotalPages();
				}else {
					currpage=num;
				}
			}
			pg.setCurrPage(currpage);
			int form=(currpage-1)*pg.getTotalPages();
			@SuppressWarnings("rawtypes")
			List lists=bs.getBookList(form, pg.getPageSize());
			pg.setPageLists(lists);
			req.getSession().setAttribute("pg", pg);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    //删除数据
	private void delBook(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			int id=Integer.parseInt(req.getParameter("id"));
			isPass=bs.delBook(id);
			PrintWriter out = resp.getWriter();
			if(isPass) {
				//删除成功
				out.write("true");
			}else {
				//删除失败
				out.write("false");
			}
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    //通过id查询数据的方法
	private void findBook(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			int id=Integer.parseInt(req.getParameter("id"));
			book=bs.getById(id);
			req.setAttribute("book", book);
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    //增加数据的方法
	private void addBook(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			String name=req.getParameter("name");
			String author=req.getParameter("author");
			String publish=req.getParameter("publish");
			String date=req.getParameter("publishdate");
			int page=Integer.parseInt(req.getParameter("page"));
			double price=Double.parseDouble(req.getParameter("price"));
			String content=req.getParameter("content");
		    book=new Book(name, author, publish, format.parse(date), page, price, content);
		    isPass=bs.addBook(book);
		    if(isPass) {
		    	resp.sendRedirect("Index?op=show");
		    }else {
		    	resp.sendRedirect("add.jsp");
		    }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
