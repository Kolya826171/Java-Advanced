package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;

public class UserMapper {

	public static User map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		String email = result.getString("email");
		String role = result.getString("role");
		String password = result.getString("password");
		
		return new User(id, firstName, lastName, email, role, password);	
	}
}
