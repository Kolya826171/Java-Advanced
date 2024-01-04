package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.Book;
import domain.Bucket;
import dto.BucketDto;
import service.BookService;
import service.BucketService;
import service.impl.BookServiceImpl;
import service.impl.BucketServiceImpl;

public class AllBuckets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BucketService bucketService = BucketServiceImpl.getBucketrService();
	private BookService bookService = BookServiceImpl.getBookService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Book> idToBook = bookService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToBook);
		
		String json = new Gson().toJson(listOfBucketDtos);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		
	}

	public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Book> idToBook) {
		
		return buckets.stream().map(bucket ->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getPurchaseDate().toString();
			
			Book book = idToBook.get(bucket.getBookId());
			bucketDto.title = book.getTitle();
			bucketDto.author = book.getAuthor();
			bucketDto.price = book.getPrice();
			return bucketDto;
		}).toList();
	}
}
