package by.htp.service;

import java.util.List;

import by.htp.bean.News;

public interface NewsService {

	List<News> takeALL() throws ServiceException;

	News takeById(int id) throws ServiceException;

	boolean editNews(News news) throws ServiceException;

	boolean deleteNews(News news) throws ServiceException;

	boolean insertNews(News news) throws ServiceException;

}
