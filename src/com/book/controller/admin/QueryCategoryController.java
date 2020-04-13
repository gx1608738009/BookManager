package com.book.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.pojo.BookCategory;
import com.book.service.admin.BookCategoryMapperService;
import com.book.service.admin.BookCategoryMapperServiceImpl;

/**
 * Servlet implementation class QueryCategoryController
 */
@WebServlet("/QueryCategoryController")
public class QueryCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BookCategoryMapperService cs=new BookCategoryMapperServiceImpl(); 
		List<BookCategory> list=cs.Query();
		HttpSession session=request.getSession();
		session.setAttribute("list", list);
		request.getRequestDispatcher("admin/category-mgr.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
