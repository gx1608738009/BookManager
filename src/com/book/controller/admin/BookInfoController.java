package com.book.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.BookInfo;
import com.book.service.admin.BookService;
import com.book.service.admin.BookServiceImpl;

/**
 * Servlet implementation class BookInfoController
 */
@WebServlet("/BookInfoController")
public class BookInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bs=new BookServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfoController() {
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
			addBook(request,response);
		}else if("delete".equals(op)) {
			deleteBook(request,response);
		}else if("update".equals(op)) {
			updateBook(request,response);
		}
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String bookName=request.getParameter("bookName");
		String author=request.getParameter("author");
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String publisher=request.getParameter("publisher");
		double price=Double.parseDouble(request.getParameter("price"));
		BookInfo book=new BookInfo(id,bookName,author,categoryId,publisher,price);
		boolean isOk=bs.updateBook(book);
		if(isOk) {
			response.sendRedirect("Book");
		}else {
			response.sendRedirect("admin/book-edit.jsp");
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		boolean isOk=bs.deleteBook(id);
		if(isOk) {
			response.sendRedirect("Book");
		}else {
			response.sendRedirect("Book");
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//获得页面上的值
		String bookName=request.getParameter("bookName");
		String author=request.getParameter("author");
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		String publisher=request.getParameter("publisher");
		double price=Double.parseDouble(request.getParameter("price"));
		BookInfo book=new BookInfo(bookName,author,categoryId,publisher,price);
		boolean isOk=bs.addBook(book);
		if(isOk) {
			response.sendRedirect("Book");
		}else {
			response.sendRedirect("Book");
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
