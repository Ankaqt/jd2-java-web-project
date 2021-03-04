package by.htp.service.impl;

import java.util.List;

import by.htp.bean.News;
import by.htp.dao.DAOException;
import by.htp.dao.DAOProvider;
import by.htp.dao.NewsDAO;
import by.htp.service.NewsService;
import by.htp.service.ServiceException;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> takeALL() throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsdao();

		List<News> news;

		try {
			news = newsDAO.takeAll();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return news;
	}

	@Override
	public News takeById(int id) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsdao();

		News news;

		try {
			news = newsDAO.takeById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return news;
	}

	@Override
	public boolean editNews(News news) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsdao();

		boolean update;

		try {
			update = newsDAO.editNews(news);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return update;

	}

	@Override
	public boolean deleteNews(News news) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsdao();

		boolean delete;

		try {
			delete = newsDAO.deleteNews(news);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return delete;

	}

	@Override
	public boolean insertNews(News news) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsdao();

		boolean insert;

		try {
			insert = newsDAO.insertNews(news);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return insert;
	}
}
