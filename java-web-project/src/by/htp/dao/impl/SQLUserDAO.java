package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.bean.User;
import by.htp.bean.RegistrationInfo;
import by.htp.dao.UserDAO;
import by.htp.dao.exception.ConnectionPoolException;
import by.htp.dao.exception.DAOException;
import by.htp.dao.impl.connection_pool.ConnectionPool;

import static by.htp.dao.impl.SQLQueryConstant.SQL_QUERY_CREATE_USER;
import static by.htp.dao.impl.SQLQueryConstant.SQL_QUERY_SELECT_USER;

public class SQLUserDAO implements UserDAO {

	private static final String USER_ID = "userinfo_id";
	private static final String USER_NAME = "userinfo_name";
	private static final String USER_EMAIL = "userinfo_email";
	private static final String USER_PHONE = "userinfo_phone";
	private static final String USER_ROLE = "userinfo_role";

	ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public User authorization(String name, String password) throws DAOException {
		User user = null;
		PreparedStatement statement = null;
		Connection con = null;

		try {
			con = connectionPool.takeConnection();
			statement = con.prepareStatement(SQL_QUERY_SELECT_USER);
			statement.setString(1, name);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(USER_ID));
				user.setName(rs.getString(USER_NAME));
				user.setEmail(rs.getString(USER_EMAIL));
				user.setPhone(rs.getString(USER_PHONE));
				user.setRole(rs.getString(USER_ROLE));

			}

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, statement);
		}
		return user;
	}

	@Override
	public boolean registrate(RegistrationInfo registrationInfo) throws DAOException {
		boolean insert;
		PreparedStatement statement = null;

		Connection con = null;

		try {
			con = connectionPool.takeConnection();
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
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, statement);
		}
		return insert;
	}

}
