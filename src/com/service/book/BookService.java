package com.service.book;

import java.util.List;

import com.entity.Book;

public interface BookService {
	//��ѯ���ݿ������
    int getCount();
    //��ҳ��ѯ���ݵķ���
    List<Book> getBookList(int currPage,int pageSize);
    //ͨ��id��ѯ���ݵķ���
    Book getById(int id);
    //�޸����ݵķ���
    boolean updateBook(Book book);
    //ɾ�����ݵķ���
    boolean delBook(int id);
    //�������ݵķ���
    boolean addBook(Book book);
}
