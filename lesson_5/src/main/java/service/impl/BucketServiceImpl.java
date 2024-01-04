package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import dao.BucketDao;
import dao.impl.BucketDaoImpl;
import domain.Bucket;
import service.BucketService;

public class BucketServiceImpl implements BucketService {

	private BucketDao bucketDao;
	public BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

	@Override
	public void insert(Bucket bucket) {
		bucketDao.insert(bucket);
	}

	@Override
	public Bucket readById(int id) {
		return bucketDao.readById(id);
	}

	@Override
	public void update(Bucket bucket) {
		bucketDao.update(bucket);
	}

	@Override
	public void delete(int id) {
		bucketDao.delete(id);
	}
}
