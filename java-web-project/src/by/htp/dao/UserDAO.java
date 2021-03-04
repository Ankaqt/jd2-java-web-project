package by.htp.dao;

import by.htp.bean.User;
import by.htp.bean.RegistrationInfo;

public interface UserDAO {

	User authorization(String name, String password) throws DAOException;

	boolean registrate(RegistrationInfo registrationInfo) throws DAOException;
}
