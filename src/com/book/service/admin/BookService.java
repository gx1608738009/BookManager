package com.book.service.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.BookInfo;

public interface BookService {
    int getCount();
	
	List<BookInfo> getPageLists(@Param("from") int currPage,@Param("pageSize") int pageSize);
	
    boolean addBook(BookInfo book);
    
	boolean deleteBook(int id);
    
	boolean updateBook(BookInfo book);
}
