package com.service.book.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.commons.MyBatisUtils;
import com.dao.book.BookMapper;
import com.entity.Book;
import com.service.book.BookService;

public class BookServiceImpl implements BookService {
         //创建一个mapper对象
	     private BookMapper mapper;
	     //创建一个集合对象
	     private List<Book> list;
	     //创建一个临时变量
	     private int result;
	     //创建一个sqlsession对象
	     private SqlSession sqlsession;
		@Override
		public int getCount() {
			sqlsession=MyBatisUtils.createSqlSession();
			mapper=sqlsession.getMapper(BookMapper.class);
			result=mapper.getCount();
			MyBatisUtils.closeSqlSession(sqlsession);
			return result;
		}
		@Override
		public List<Book> getBookList(int currPage, int pageSize) {
			sqlsession=MyBatisUtils.createSqlSession();
			mapper=sqlsession.getMapper(BookMapper.class);
			list=mapper.getBookList(currPage, pageSize);
			MyBatisUtils.closeSqlSession(sqlsession);
			return list;
		}
		@Override
		public Book getById(int id) {
			sqlsession=MyBatisUtils.createSqlSession();
			mapper=sqlsession.getMapper(BookMapper.class);
			Book book=mapper.getById(id);
			MyBatisUtils.closeSqlSession(sqlsession);
			return book;
		}
		@Override
		public boolean updateBook(Book book) {
			sqlsession=MyBatisUtils.createSqlSession();
			mapper=sqlsession.getMapper(BookMapper.class);
			result=mapper.updateBook(book);
			if(result>0) {
				sqlsession.commit();
				MyBatisUtils.closeSqlSession(sqlsession);
				return true;
			}else {
				MyBatisUtils.closeSqlSession(sqlsession);
			    return false;
			}
		}
		@Override
		public boolean delBook(int id) {
			sqlsession=MyBatisUtils.createSqlSession();
			mapper=sqlsession.getMapper(BookMapper.class);
			result=mapper.delBook(id);
			if(result>0) {
				sqlsession.commit();
				MyBatisUtils.closeSqlSession(sqlsession);
				return true;
			}else {
				MyBatisUtils.closeSqlSession(sqlsession);
			    return false;
			}
		}
		@Override
		public boolean addBook(Book book) {
			sqlsession=MyBatisUtils.createSqlSession();
			mapper=sqlsession.getMapper(BookMapper.class);
			result=mapper.addBook(book);
			if(result>0) {
				sqlsession.commit();
				MyBatisUtils.closeSqlSession(sqlsession);
				return true;
			}else {
				MyBatisUtils.closeSqlSession(sqlsession);
			    return false;
			}
		}
}
