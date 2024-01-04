package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;
import service.BookService;
import service.impl.BookServiceImpl;

public class Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BookService bookService = BookServiceImpl.getBookService();

	private double getValidatedPrice(String price) {
		if (price == null || price.isEmpty()) {
			return 0;
		} else {
			return Double.parseDouble(price);
		}
	}

	// to create book
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");

		if (!title.isEmpty() && !author.isEmpty()) {
			bookService.insert(new Book(title, author, getValidatedPrice(price)));
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	// to read(get) book
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	// to update book
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	// to delete book
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
