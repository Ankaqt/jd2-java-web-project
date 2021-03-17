package by.htp.service;

import java.util.List;

import by.htp.bean.News;
import by.htp.service.exception.NewsException;
import by.htp.service.exception.ServiceException;

public interface NewsService {

	List<News> takeALL() throws ServiceException;

	News takeById(int id) throws ServiceException;

	boolean editNews(News news) throws ServiceException, NewsException;

	boolean deleteNews(News news) throws ServiceException;

	boolean insertNews(News news) throws ServiceException, NewsException;

}
