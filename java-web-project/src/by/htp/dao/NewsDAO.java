package by.htp.dao;

import java.util.List;

import by.htp.bean.News;

public interface NewsDAO {

	List<News> takeAll() throws DAOException;

	News takeById(int id) throws DAOException;

	boolean editNews(News news) throws DAOException;

	boolean deleteNews(News news) throws DAOException;

	boolean insertNews(News news) throws DAOException;

}
