package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.bean.User;
import by.htp.bean.RegistrationInfo;
import by.htp.dao.DAOException;
import by.htp.dao.UserDAO;

public class SQLUserDAO implements UserDAO {

	public static final String SQL_QUERY_SELECT_USER = "SELECT * from userinfo where userinfo_name=? and userinfo_password=?";
	public static final String SQL_QUERY_CREATE_USER = "INSERT INTO userinfo(userinfo_name,userinfo_email,userinfo_phone,userinfo_password) VALUES(?,?,?,?)";

	private String dbUrl = "jdbc:mysql://localhost:3307/news_management?useSSL=false&serverTimezone=UTC";
	private String dbUname = "root";
	private String password = "okmijn19731973";

	static {
		MySQLDriverLoader.getInstance();
	}

	public Connection getConnection() throws DAOException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, password);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return con;

	}

	public void closeConnection(Connection con) throws DAOException {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public User authorization(String name, String password) throws DAOException {
		User user = null;
		PreparedStatement statement = null;

		Connection con = getConnection();

		try {

			statement = con.prepareStatement(SQL_QUERY_SELECT_USER);
			statement.setString(1, name);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("userinfo_id"));
				user.setName(rs.getString("userinfo_name"));
				user.setEmail(rs.getString("userinfo_email"));
				user.setPhone(rs.getString("userinfo_phone"));
				user.setRole(rs.getString("userinfo_role"));

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		return user;
	}

	@Override
	public boolean registrate(RegistrationInfo registrationInfo) throws DAOException {
		boolean insert;
		PreparedStatement statement = null;

		Connection con = getConnection();

		try {

			statement = con.prepareStatement(SQL_QUERY_CREATE_USER);

			statement.setString(1, registrationInfo.getName());
			statement.setString(2, registrationInfo.getEmail());
			statement.setString(3, registrationInfo.getPhone());
			statement.setString(4, registrationInfo.getPassword());

			int result = statement.executeUpdate();

			if (result > 0) {
				insert = true;
			} else {
				insert = false;
				System.out.println("FALSE");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		return insert;
	}

}
