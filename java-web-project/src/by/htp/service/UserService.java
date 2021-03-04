package by.htp.service;

import by.htp.bean.User;
import by.htp.bean.RegistrationInfo;

public interface UserService {

	User authorization(String name, String password) throws ServiceException;

	boolean registrate(RegistrationInfo registrationInfo) throws ServiceException;

}
