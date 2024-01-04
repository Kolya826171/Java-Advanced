package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.BookDao;
import domain.Book;
import mapper.BookMapper;
import utils.ConnectionUtils;

public class BookDaoImpl implements BookDao {
	private static final String READ_ALL = "select * from books";
	private static final String READ_BY_ID = "select * from books where id = ?";
	private static final String INSERT = "insert into books (title, author, price) value(?, ?, ?)";
	private static final String UPDATE = "update books set title = ?, author = ?, price = ? where id = ?";
	private static final String DELETE = "delete from books where id = ?";

	private static Logger LOGGER = Logger.getLogger(BookDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public BookDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public List<Book> readAll() {
		ResultSet result = null;
		List<Book> listOfBooks = new ArrayList();

		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfBooks.add(BookMapper.map(result));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return listOfBooks;
	}

	@Override
	public void insert(Book book) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setDouble(3, book.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public Book readById(int id) {
		ResultSet result = null;
		Book book = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			result.next();
			book = BookMapper.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return book;
	}

	@Override
	public void update(Book book) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setDouble(3, book.getPrice());
			preparedStatement.setInt(4, book.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

}
