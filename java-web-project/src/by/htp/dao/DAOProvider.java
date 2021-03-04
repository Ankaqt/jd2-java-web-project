package by.htp.dao;

import by.htp.dao.impl.SQLNewsDAO;
import by.htp.dao.impl.SQLUserDAO;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();

	private final UserDAO userdao = new SQLUserDAO();
	private final NewsDAO newsdao = new SQLNewsDAO();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public NewsDAO getNewsdao() {
		return newsdao;
	}

}
