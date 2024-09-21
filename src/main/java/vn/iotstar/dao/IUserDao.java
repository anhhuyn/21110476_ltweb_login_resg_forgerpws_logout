package vn.iotstar.dao;
import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	
	List<UserModel> findAll();
	
	UserModel findByUser(String username);
	
	void insert(UserModel user);
	
	
}
