package vn.iotstar.services.impl;

import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();
	

	
	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUser(username);
		
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
		
	}
	
	public static void main(String[] args) {

		try {
			IUserService userService = new UserServiceImpl();
			System.out.println(userService.login("huyen", "123"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}			
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new UserModel( username, email, fullname, password, null, 3,phone,date ));
			return true;

	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
		
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
		
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
		
	}
	
	

}
