package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import domain.Bucket;

public class BucketMapper {

	public static Bucket map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int userId = result.getInt("user_id");
		int bookId = result.getInt("book_id");
		LocalDate purchaseDate = result.getDate("purchase_Date").toLocalDate();

		return new Bucket(id, userId, bookId, purchaseDate);
	}
}
