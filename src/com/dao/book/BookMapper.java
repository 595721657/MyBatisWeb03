package com.dao.book;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Book;

public interface BookMapper {
       //查询数据库的条数
       int getCount();
       //分页查询数据的方法
       List<Book> getBookList(@Param("currPage") int currPage,@Param("pageSize") int pageSize);
       //通过id查询数据的方法
       Book getById(@Param("id") int id);
       //修改数据的方法
       int updateBook(Book book);
       //删除数据的方法
       int delBook(@Param("id") int id);
       //增加数据的方法
       int addBook(Book book);
}
