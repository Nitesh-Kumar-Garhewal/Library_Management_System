package com.pojo;


public class Book  {
   //parent class:java.lang.Object
	//data members and columns name and type  will be same
	// bookid | name         | author | price
	
	private int bookid;
	private String name;
	private String author;
	private double price;
	
	public Book(int bookid, String name, String author, double price) {
		super();
		this.bookid = bookid;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public Book() {
		super();
	}
	
	
	
}
