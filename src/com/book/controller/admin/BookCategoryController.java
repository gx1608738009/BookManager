package com.book.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.BookCategory;
import com.book.service.admin.BookCategoryMapperService;
import com.book.service.admin.BookCategoryMapperServiceImpl;

/**
 * Servlet implementation class BookCategoryController
 */
@WebServlet("/BookCategoryController")
public class BookCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookCategoryMapperService cs=new BookCategoryMapperServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String op=request.getParameter("op");
		if("add".equals(op)) {
			addCate(request,response);
		}else if("delete".equals(op)) {
			deleteCate(request,response);
		}
	}

	private void deleteCate(HttpServletRequest request, HttpServletResponse response)throws IOException  {
		int id=Integer.parseInt(request.getParameter("id"));
		boolean isOk=cs.deleteCate(id);
		if(isOk) {
			response.sendRedirect("QueryCategoryController");
		}else {
			response.sendRedirect("admin/category-mgr.jsp");
		}
	}
	private void addCate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获得页面上的数据
		String category=request.getParameter("category");
		BookCategory bc=new BookCategory(category);
		boolean isOk=cs.addCate(bc);
		if(isOk) {
			response.sendRedirect("QueryCategoryController");
		}else {
			response.sendRedirect("admin/category-mgr.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
