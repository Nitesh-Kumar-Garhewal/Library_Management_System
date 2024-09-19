package com.tester;

import java.util.List;
import java.util.Scanner;

import com.dao.BookDAO;
import com.pojo.Book;

public class TestBookCRUD {

	public static void main(String[] args) {
		// Clinet
		System.out.println("1:GetAll 2:Add Book 3:edit book 4:delete 5:getById 6:exit");

		int choice;
		BookDAO bkDao = new BookDAO();// connection
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Choice:");
			choice = sc.nextInt();
			switch (choice) {
			
			case 1:
				List<Book> list = bkDao.getAllBooks();
				list.forEach(b -> System.out.println(b));
				break;
				
			case 2:
				System.out.println("Enter BookId Name Author Price");

				int id = sc.nextInt();
				String name = sc.next();
				String author = sc.next();
				double price = sc.nextDouble();

				Book bk = new Book(id, name, author, price);
				int i = bkDao.addNewBook(bk);
				if (i == 1)
					System.out.println("inserted");
				break;
				
			case 3:
				System.out.println("Enter BookId Name Author Price to Update");
				
				Book bkUpdate=new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
				i=bkDao.editBook(bkUpdate);
				if (i == 1)
					System.out.println("Updated");
				break;
				
			case 4:
				System.out.println("Enter Bookid");
				bkDao.deleteBook(sc.nextInt());

				System.out.println("deleted");
			
				break;
				
			case 5:
				System.out.println("Enter Id");
			    Book bkObj1=  bkDao.getBookById(sc.nextInt());
			    if(bkObj1!=null)
			    {
			    System.out.println(bkObj1);	
			    }
				break;

			}
		} while (choice != 6);

		System.out.println("---Thank For Using Application------");

	}

}
