package com.dao.book;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Book;

public interface BookMapper {
       //��ѯ���ݿ������
       int getCount();
       //��ҳ��ѯ���ݵķ���
       List<Book> getBookList(@Param("currPage") int currPage,@Param("pageSize") int pageSize);
       //ͨ��id��ѯ���ݵķ���
       Book getById(@Param("id") int id);
       //�޸����ݵķ���
       int updateBook(Book book);
       //ɾ�����ݵķ���
       int delBook(@Param("id") int id);
       //�������ݵķ���
       int addBook(Book book);
}
