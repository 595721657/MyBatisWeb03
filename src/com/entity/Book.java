package com.entity;
/***
 * 图书实体
 * @author 黄龙
 * @@创建时间 2020年4月4日下午12:29:55
 */

import java.util.Date;

public class Book {
     private int id;
     private String name;
     private String author;
     private String publish;
     private Date publishdate;
     private int page;
     private double price;
     private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Book(String name, String author, String publish, Date publishdate, int page, double price, String content) {
		super();
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.publishdate = publishdate;
		this.page = page;
		this.price = price;
		this.content = content;
	}
	public Book() {
		super();
	}
	public Book(int id, String name, String author, String publish, Date publishdate, int page, double price,
			String content) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.publishdate = publishdate;
		this.page = page;
		this.price = price;
		this.content = content;
	}
	
}
