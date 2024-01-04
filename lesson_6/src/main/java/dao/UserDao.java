package dao;

import domain.User;
import shared.AbstractCrud;

public interface UserDao extends AbstractCrud<User>{

	User readByEmail(String email);
}
