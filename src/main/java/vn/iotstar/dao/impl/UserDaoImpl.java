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
		String sql = "INSERT INTO [Users](username, email, fullname, password, images, roleid,phone,createdate) VALUES (?,?,?,?,?,?,?, ?)";
				try {
				conn = new DBConnectSQLServer().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getFullname());
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getImages());
				ps.setInt(6,user.getRoleid());
				ps.setString(7,user.getPhone());
				ps.setDate(8, user.getCreatedate());
				ps.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}

		
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

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [Users] where email = ?";
		try {
		conn = new DBConnectSQLServer().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;

	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [Users] where username = ?";
		try {
		conn = new DBConnectSQLServer().getConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		 boolean duplicate = false;
		    String query = "select * from [Users] where phone = ?";
		    try {
		        conn = new DBConnectSQLServer().getConnection();
		        ps = conn.prepareStatement(query);
		        ps.setString(1, phone);
		        rs = ps.executeQuery();
		        if (rs.next()) {
		            duplicate = true; // Số điện thoại đã tồn tại
		        }
		        ps.close();
		        conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace(); // In ra lỗi để dễ dàng debug
		    }
		    return duplicate;
	}

	

	
}