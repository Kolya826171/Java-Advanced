package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import service.BookService;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao;
	public BookServiceImpl() {
		try {
			bookDao = new BookDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Book> readAll() {
		return bookDao.readAll();
	}
	
	@Override
	public void insert(Book book) {
		bookDao.insert(book);
	}
	
	@Override
	public Book readById(int id) {
		return bookDao.readById(id);
	}
	
	@Override
	public void update(Book book) {
		bookDao.update(book);
	}
	
	@Override
	public void delete(int id) {
		bookDao.delete(id);
	}
	
}
