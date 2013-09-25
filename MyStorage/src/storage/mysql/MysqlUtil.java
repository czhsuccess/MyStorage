package storage.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import storage.config.ConfigServiceImpl;
import storage.config.IConfigService;
import storage.config.model.MysqlConfig;

import com.mysql.jdbc.PreparedStatement;

public class MysqlUtil {
	private static IConfigService configService = new ConfigServiceImpl();
	
	public static byte[] parseResult(String sql, String field) throws Exception {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			connection = getConnection();
			st = (PreparedStatement) connection.prepareStatement(sql);
			st.setString(1, field);
			rs = st.executeQuery();
			
			byte[] bytes = null;
			while (rs.next()) {
				bytes = rs.getBytes(1);
			}
			
			return bytes; //todo:如果结果多于一条如何处理？
			
		} catch (SQLException e) {
			//todo
		} finally {
			releaseResource(connection, st, rs);
		}
		return null;
	}
	
	public static boolean parseResult(String sql, String key, byte[] value, boolean upDate) throws Exception {
		Connection connection = getConnection();
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
		boolean success = false;
		try{
			if(upDate) {
				st.setBytes(1, value);
				st.setString(2, key);
				st.executeUpdate();
				success = true;
			} else {
				st.setString(1, key);
				st.setBytes(2, value);
				st.executeUpdate();
				success = true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(null != st) st.close();
		}
		
		return success;
	}
	
	public static boolean parseResult(String sql, String key, boolean isDelete) {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			PreparedStatement st = (PreparedStatement) connection.prepareStatement(sql);
			st.setString(1, key);
			success = st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	private static void releaseResource(Connection connection, Statement st,
			ResultSet rs) throws Exception {
		try {
			if (rs != null)
				rs.close();
		} finally {
			try {
				if(st != null)
					st.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}

	}
	
	private static Connection getConnection() throws Exception {
		MysqlConfig mysqlConfig = configService.getMysqlConfig();
		String driverClass = "com.mysql.jdbc.Driver";
		String url = mysqlConfig.getUrl();
		String user = mysqlConfig.getUser();
		String password = mysqlConfig.getPass();

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
}