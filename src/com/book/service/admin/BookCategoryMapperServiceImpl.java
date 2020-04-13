package com.book.service.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.commons.MybatisUtils;
import com.book.dao.admin.BookCategoryMapper;
import com.book.pojo.BookCategory;

public class BookCategoryMapperServiceImpl implements BookCategoryMapperService {
    private SqlSession sqlSession;
	@Override
	public List<BookCategory> Query() {
		sqlSession=MybatisUtils.createSqlSession();
		List<BookCategory> list=sqlSession.getMapper(BookCategoryMapper.class).Query();
		MybatisUtils.closeSqlSession(sqlSession);
		return list;
	}

	@Override
	public boolean addCate(BookCategory bc) {
		sqlSession=MybatisUtils.createSqlSession();
		int result=sqlSession.getMapper(BookCategoryMapper.class).addCate(bc);
		if(result>0) {
			sqlSession.commit();
			return true;
		}else {
			sqlSession.rollback();
		}
		MybatisUtils.closeSqlSession(sqlSession);
		return false;
	}

	@Override
	public boolean deleteCate(int id) {
		sqlSession=MybatisUtils.createSqlSession();
		int result=sqlSession.getMapper(BookCategoryMapper.class).deleteCate(id);
		if(result>0) {
			sqlSession.commit();
			return true;
		}else {
			sqlSession.rollback();
		}
		MybatisUtils.closeSqlSession(sqlSession);
		return false;
	}

}
