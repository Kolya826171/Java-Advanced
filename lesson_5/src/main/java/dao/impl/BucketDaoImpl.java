package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BucketDao;
import domain.Bucket;
import mapper.BucketMapper;
import utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {
	private static final String READ_ALL = "select * from bucket";
	private static final String READ_BY_ID = "select * from bucket where id = ?";
	private static final String INSERT = "insert into bucket (user_id, book_id, purchase_date) value(?, ?, ?)";
	private static final String UPDATE = "update bucket set user_id = ?, book_id = ?, purchase_date = ? where id = ?";
	private static final String DELETE = "delete from bucket where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public List<Bucket> readAll() {
		ResultSet result = null;
		List<Bucket> bucketRecords = new ArrayList();

		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				bucketRecords.add(BucketMapper.map(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bucketRecords;
	}

	@Override
	public void insert(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getBookId());
			preparedStatement.setDate(3, Date.valueOf(bucket.getPurchaseDate()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Bucket readById(int id) {
		ResultSet result = null;
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			result.next();
			bucket = BucketMapper.map(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public void update(Bucket bucket) {
		throw new IllegalStateException("You can't update your bucket.");
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
