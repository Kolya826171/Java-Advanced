import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.Book;
import domain.Bucket;
import domain.User;
import service.BookService;
import service.BucketService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.BucketServiceImpl;
import service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		BookService bookService = new BookServiceImpl();
		BucketService bucketService = new BucketServiceImpl();

		List<User> uesrList = new ArrayList();

		uesrList = userService.readAll();
		System.out.println(uesrList);
		System.out.println(userService.readById(2));
		
		List<Book> bookList = new ArrayList();

		bookList = bookService.readAll();
		System.out.println(bookList);
		System.out.println(bookService.readById(1));
		
		List<Bucket> bucketList = new ArrayList();

		bucketList = bucketService.readAll();
		System.out.println(bucketList);
		System.out.println(bucketService.readById(2));
		bucketService.delete(4);

	}

}
