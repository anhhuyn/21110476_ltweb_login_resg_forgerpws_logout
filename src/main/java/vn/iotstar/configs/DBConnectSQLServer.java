package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import vn.iotstar.models.UserModel;

public class DBConnectSQLServer {
	private final String serverName = "LAPTOP-6EMR4237";
	private final String dbName = "ltwebct2";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "@Huyen171003";

	public Connection getConnection() throws Exception {
		Connection conn = null;

		try {
			String url = "jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName="+dbName;

			if (instance == null || instance.trim().isEmpty())

				url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
			
			//Class.forName("com.microsoft.sqlserver.jbdc.SQLServerDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, userID, password);
			
			
			if (conn != null) {

				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());

				return conn;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
  // Co ham main chay bang java application
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQLServer().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}