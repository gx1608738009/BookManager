package com.book.service.admin;

import java.util.List;

import com.book.pojo.BookCategory;

public interface BookCategoryMapperService {
    List<BookCategory> Query();
    
    boolean addCate(BookCategory bc);

	boolean deleteCate(int id);
}
