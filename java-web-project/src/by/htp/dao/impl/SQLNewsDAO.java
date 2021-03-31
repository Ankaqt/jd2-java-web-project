package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.htp.bean.News;
import by.htp.dao.NewsDAO;
import by.htp.dao.exception.ConnectionPoolException;
import by.htp.dao.exception.DAOException;
import by.htp.dao.impl.connection_pool.ConnectionPool;

import static by.htp.dao.impl.SQLQueryConstant.SQL_QUERY_ADD_NEWS;
import static by.htp.dao.impl.SQLQueryConstant.SQL_QUERY_SELECT_ALL_NEWS;
import static by.htp.dao.impl.SQLQueryConstant.SQL_QUERY_DELETE_NEWS;
import static by.htp.dao.impl.SQLQueryConstant.SQL_QUERY_SELECT_NEWS_BY_ID;
import static by.htp.dao.impl.SQLQueryConstant.SQL_QUERY_UPDATE_NEWS;

public class SQLNewsDAO implements NewsDAO {

	private static final String NEWS_ID = "news_id";
	private static final String NEWS_TITLE = "news_title";
	private static final String NEWS_BRIEF = "news_brief";
	private static final String NEWS_CONTENT = "news_content";
	private static final String NEWS_DATE = "news_date";

	ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public List<News> takeAll() throws DAOException {
		List<News> news = null;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			con = connectionPool.takeConnection();

			st = con.createStatement();

			rs = st.executeQuery(SQL_QUERY_SELECT_ALL_NEWS);

			news = new ArrayList<News>();

			while (rs.next()) {
				int id = rs.getInt(NEWS_ID);
				String title = rs.getString(NEWS_TITLE);
				String brief = rs.getString(NEWS_BRIEF);
				String content = rs.getString(NEWS_CONTENT);
				LocalDate date = rs.getDate(NEWS_DATE).toLocalDate();

				News n = new News(id, title, brief, content, date);

				news.add(n);

			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);

		} finally {
			connectionPool.closeConnection(con, st, rs);
		}
		return news;
	}

	@Override
	public News takeById(int id) throws DAOException {
		News news = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = connectionPool.takeConnection();
			statement = con.prepareStatement(SQL_QUERY_SELECT_NEWS_BY_ID);
			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {
				String title = rs.getString(NEWS_TITLE);
				String brief = rs.getString(NEWS_BRIEF);
				String content = rs.getString(NEWS_CONTENT);
				LocalDate date = rs.getDate(NEWS_DATE).toLocalDate();

				news = new News(id, title, brief, content, date);
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, statement, rs);
		}

		return news;
	}

	@Override
	public boolean editNews(News news) throws DAOException {
		boolean update;
		PreparedStatement statement = null;

		Connection con = null;

		try {
			con = connectionPool.takeConnection();
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

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, statement);
		}
		return update;
	}

	@Override
	public boolean deleteNews(News news) throws DAOException {

		boolean delete;
		PreparedStatement statement = null;

		Connection con = null;

		try {
			con = connectionPool.takeConnection();
			statement = con.prepareStatement(SQL_QUERY_DELETE_NEWS);
			statement.setInt(1, news.getId());

			int result = statement.executeUpdate();

			if (result > 0) {
				delete = true;
			} else {
				delete = false;
			}

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, statement);
		}
		return delete;
	}

	@Override
	public boolean insertNews(News news) throws DAOException {

		boolean insert;
		PreparedStatement statement = null;

		Connection con = null;

		try {
			con = connectionPool.takeConnection();
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
		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			connectionPool.closeConnection(con, statement);
		}
		return insert;
	}
}
