package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.htp.bean.News;
import by.htp.dao.DAOException;
import by.htp.dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO {

	public static final String SQL_QUERY_SELECT_ALL_NEWS = "SELECT * FROM news WHERE news_status ='active'";
	public static final String SQL_QUERY_SELECT_NEWS_BY_ID = "SELECT * FROM news WHERE news_id = ?";
	public static final String SQL_QUERY_UPDATE_NEWS = "UPDATE news SET news_title = ?, news_brief = ?, news_content = ? WHERE news_id = ?";
	public static final String SQL_QUERY_DELETE_NEWS = "UPDATE news SET news_status ='inactive' WHERE news_id = ?";
	public static final String SQL_QUERY_ADD_NEWS = "INSERT INTO news (news_title, news_brief, news_content, news_date) VALUES (?, ?, ?, ?)";

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
	public List<News> takeAll() throws DAOException {
		List<News> news = null;
		Statement st = null;
		ResultSet rs = null;

		Connection con = getConnection();

		try {

			st = con.createStatement();

			rs = st.executeQuery(SQL_QUERY_SELECT_ALL_NEWS);

			news = new ArrayList<News>();

			while (rs.next()) {
				int id = rs.getInt("news_id");
				String title = rs.getString("news_title");
				String brief = rs.getString("news_brief");
				String content = rs.getString("news_content");
				LocalDate date = rs.getDate("news_date").toLocalDate();
				News n = new News(id, title, brief, content, date);

				news.add(n);

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		return news;
	}

	@Override
	public News takeById(int id) throws DAOException {
		News news = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		Connection con = getConnection();

		try {

			statement = con.prepareStatement(SQL_QUERY_SELECT_NEWS_BY_ID);
			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {
				String title = rs.getString("news_title");
				String brief = rs.getString("news_brief");
				String content = rs.getString("news_content");
				LocalDate date = rs.getDate("news_date").toLocalDate();

				news = new News(id, title, brief, content, date);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}

		return news;
	}

	@Override
	public boolean editNews(News news) throws DAOException {
		boolean update;
		PreparedStatement statement = null;

		Connection con = getConnection();

		try {

			statement = con.prepareStatement(SQL_QUERY_UPDATE_NEWS);

			statement.setString(1, news.getTitle());
			statement.setString(2, news.getBrief());
			statement.setString(3, news.getContent());
			statement.setInt(4, news.getId());

			int result = statement.executeUpdate();

			if (result > 0) {
				update = true;
			} else {
				update = false;
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		return update;
	}

	@Override
	public boolean deleteNews(News news) throws DAOException {

		boolean delete;
		PreparedStatement statement = null;

		Connection con = getConnection();

		try {

			statement = con.prepareStatement(SQL_QUERY_DELETE_NEWS);
			statement.setInt(1, news.getId());

			int result = statement.executeUpdate();

			if (result > 0) {
				delete = true;
			} else {
				delete = false;
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		return delete;
	}

	@Override
	public boolean insertNews(News news) throws DAOException {

		boolean insert;
		PreparedStatement statement = null;

		Connection con = getConnection();

		try {

			statement = con.prepareStatement(SQL_QUERY_ADD_NEWS);

			statement.setString(1, news.getTitle());
			statement.setString(2, news.getBrief());
			statement.setString(3, news.getContent());
			statement.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));

			int result = statement.executeUpdate();

			if (result > 0) {
				insert = true;
			} else {
				insert = false;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		return insert;
	}
}
