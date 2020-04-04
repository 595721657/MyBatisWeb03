package com.service.book;

import java.util.List;

import com.entity.Book;

public interface BookService {
	//查询数据库的条数
    int getCount();
    //分页查询数据的方法
    List<Book> getBookList(int currPage,int pageSize);
    //通过id查询数据的方法
    Book getById(int id);
    //修改数据的方法
    boolean updateBook(Book book);
    //删除数据的方法
    boolean delBook(int id);
    //增加数据的方法
    boolean addBook(Book book);
}
