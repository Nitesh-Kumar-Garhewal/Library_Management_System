package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Book;
import com.util.DbUtil;

public class BookDAO {

	// Connection

	private Connection con;

	public BookDAO() {
		con = DbUtil.getDBConnection();
		System.out.println("---BookDAO Created------");
	}

	// select * from book :R
	public List<Book> getAllBooks() {
		List<Book> booksList = new ArrayList<Book>();// isEmpty-->true

		// sql
		String sql = "select * from book";
		// Statement
		try {
			Statement stmt = con.createStatement();
			// execute query
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {

				Book bkObj = new Book(rset.getInt("bookid"), rset.getString("name"), rset.getString("author"),
						rset.getDouble("price"));

				booksList.add(bkObj);

			}
			rset.close();
			return booksList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// insert

	public int addNewBook(Book bkObj) {
		System.out.println("----inside addNewBook-----");

		// sql
		String strInsert = "insert into book values(?,?,?,?)";
		try {

			PreparedStatement pstmt = con.prepareStatement(strInsert);

			pstmt.setInt(1, bkObj.getBookid());
			pstmt.setString(2, bkObj.getName());
			pstmt.setString(3, bkObj.getAuthor());
			pstmt.setDouble(4, bkObj.getPrice());

			int i = pstmt.executeUpdate();
			System.out.println("Inserted Book:" + bkObj);
			return i;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

	public int editBook(Book bkObj) {
		System.out.println("----inside addNewBook-----");

		// sql
		String strUpdate = "update book set name=?,author=?,price=? where  bookid=?";
		try {

			PreparedStatement pstmt = con.prepareStatement(strUpdate);

			pstmt.setString(1, bkObj.getName());
			pstmt.setString(2, bkObj.getAuthor());
			pstmt.setDouble(3, bkObj.getPrice());
			pstmt.setInt(4, bkObj.getBookid());

			int i = pstmt.executeUpdate();
			System.out.println("Updated Book:" + bkObj);
			return i;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;

	}

		
	public int deleteBook(int id) {
		
		
		try {
			System.out.println("-----inside deleteBook------");
			
			String str= "delete from Book where bookid="+id;
			Statement stmt=con.createStatement();
			int i=stmt.executeUpdate(str);
			System.out.println("deleted "+ i + " rows");
			
			return i;
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
		
		
	}
	
	

	public Book getBookById(int id) {
		String sql = "select * from book where bookid=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rset = pstmt.executeQuery();

			if (rset.next()) {
				System.out.println("---book is present-----");

				Book bkObj = new Book(rset.getInt("bookid"), rset.getString("name"), rset.getString("author"),
						rset.getDouble("price"));
				return bkObj;
			} else {
				System.out.println("---invalid id----");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}

}
