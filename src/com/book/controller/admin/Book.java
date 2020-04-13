package com.book.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.Pager;
import com.book.service.admin.BookService;
import com.book.service.admin.BookServiceImpl;

/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bs=new BookServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pageIndex=request.getParameter("pageIndex");
		int currpage=1;
		//创建一个分页类对象
		Pager pg=new Pager();
		//获得数据库中数据的总条数
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
		int from=(currpage-1)*pg.getPageSize();
		List pageLists=bs.getPageLists(from, pg.getPageSize());
		pg.setPageLists(pageLists);
		request.getSession().setAttribute("pg", pg);
		response.sendRedirect("admin/book-mgr.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
