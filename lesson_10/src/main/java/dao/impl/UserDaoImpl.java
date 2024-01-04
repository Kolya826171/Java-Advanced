package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.UserDao;
import domain.User;
import mapper.UserMapper;
import utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {
	private static final String READ_ALL = "select * from users";
	private static final String READ_BY_ID = "select * from users where id = ?";
	private static final String READ_BY_EMAIL = "select * from users where email = ?";
	private static final String INSERT = "insert into users (first_name, last_name, email, role, password) value(?, ?, ?, ?, ?)";
	private static final String UPDATE = "update users set first_name = ?, last_name = ?, email = ?, role = ?, password = ? where id = ?";
	private static final String DELETE = "delete from users where id = ?";

	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	private Connection connection;
	private PreparedStatement preparedStatement;

	public UserDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public List<User> readAll() {
		ResultSet result = null;
		List<User> listOfUsers = new ArrayList();

		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfUsers.add(UserMapper.map(result));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return listOfUsers;
	}

	@Override
	public void insert(User user) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public User readById(int id) {
		ResultSet result = null;
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			result.next();
			user = UserMapper.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;
	}

	@Override
	public void update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setInt(6, user.getId());
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

	@Override
	public User readByEmail(String email) {
		ResultSet result = null;
		User user = null;

		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			result = preparedStatement.executeQuery();
			result.next();
			user = UserMapper.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return user;
	}

}
