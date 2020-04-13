package com.book.service.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.commons.MybatisUtils;
import com.book.dao.admin.BookInfoMapper;
import com.book.dao.book.BookMapper;
import com.book.pojo.BookInfo;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession;

	@Override
	public int getCount() {
		sqlSession=MybatisUtils.createSqlSession();
		int count=sqlSession.getMapper(com.book.dao.admin.BookInfoMapper.class).getCount();
		MybatisUtils.closeSqlSession(sqlSession);
		return count;
	}

	@Override
	public List<BookInfo> getPageLists(int currPage, int pageSize) {
		sqlSession=MybatisUtils.createSqlSession();
		List<BookInfo> pageLists=sqlSession.getMapper(com.book.dao.admin.BookInfoMapper.class).getPageLists(currPage, pageSize);
		MybatisUtils.closeSqlSession(sqlSession);
		return pageLists;
	}

	@Override
	public boolean addBook(BookInfo book) {
		sqlSession=MybatisUtils.createSqlSession();
		int result=sqlSession.getMapper(BookInfoMapper.class).addBook(book);
		if(result>0){
			sqlSession.commit();
			return true;
		}else {
			sqlSession.rollback();
		}
		MybatisUtils.closeSqlSession(sqlSession);
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		sqlSession=MybatisUtils.createSqlSession();
		int result=sqlSession.getMapper(BookInfoMapper.class).deleteBook(id);
		if(result>0){
			sqlSession.commit();
			return true;
		}else {
			sqlSession.rollback();
		}
		MybatisUtils.closeSqlSession(sqlSession);
		return false;
	}

	@Override
	public boolean updateBook(BookInfo book) {
		sqlSession=MybatisUtils.createSqlSession();
		int result=sqlSession.getMapper(BookInfoMapper.class).updateBook(book);
		if(result>0){
			sqlSession.commit();
			return true;
		}else {
			sqlSession.rollback();
		}
		MybatisUtils.closeSqlSession(sqlSession);
		return false;
	}
}
