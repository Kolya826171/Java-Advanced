package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Book;

public class BookMapper {

	public static Book map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String title = result.getString("title");
		String author = result.getString("author");
		double price = result.getDouble("price");
		
		return new Book(id, title, author, price);
	}
}
