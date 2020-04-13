package com.book.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.BookCategory;

public interface BookCategoryMapper {
    List<BookCategory> Query();
    
    int addCate(BookCategory bc);

	int deleteCate(@Param("id") int id);
}
