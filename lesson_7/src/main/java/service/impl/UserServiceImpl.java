package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	private static UserServiceImpl userServiceImpl;
	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	private UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | SQLException e) {
			LOGGER.error(e);
		}
	}
	
	public static UserService getUserService() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public User readById(int id) {
		return userDao.readById(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User readByEmail(String email) {
		return userDao.readByEmail(email);
	}

}
