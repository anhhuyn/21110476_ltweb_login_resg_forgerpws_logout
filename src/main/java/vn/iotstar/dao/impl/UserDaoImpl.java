package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import vn.iotstar.configs.DBConnectSQLServer;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectSQLServer implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findByUser(String username) {
		String sql = "SELECT * FROM [Users] WHERE username =? ";
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
			UserModel user = new UserModel();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));
			user.setFullname(rs.getString("fullname"));
			user.setPassword(rs.getString("password"));
			user.setImages(rs.getString("images"));
			user.setRoleid(Integer.parseInt(rs.getString("roleid")));
			user.setPhone(rs.getString("phone"));
			user.setCreatedate(rs.getDate("createdate"));
			return user; }
			} catch (Exception e) {e.printStackTrace(); }
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		/*UserDaoImpl userDao = new UserDaoImpl();
		
		userDao.insert(new UserModel(2,"abc","abc@gmail.com","123","abcde",""));
		
		List<UserModel> list = userDao.findAll();
		
		for (UserModel user : list) {
			System.out.println(user);
		}*/
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUser("huyen"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

	
}