package com.book.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.BookInfo;

public interface BookInfoMapper {
	// 获得图书信息的方法
    int getCount();
    
    List<BookInfo> getPageLists(@Param("from") int currPage,@Param("pageSize") int pageSize);
    
    int addBook(BookInfo book);
    
    int deleteBook(@Param("id") int id);
    
    int updateBook(BookInfo book);
}
