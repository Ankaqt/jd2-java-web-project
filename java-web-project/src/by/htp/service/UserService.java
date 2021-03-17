package by.htp.service;

import by.htp.bean.User;
import by.htp.service.exception.ServiceException;
import by.htp.service.exception.UserException;
import by.htp.bean.RegistrationInfo;

public interface UserService {

	User authorization(String name, String password) throws ServiceException, UserException;

	boolean registrate(RegistrationInfo registrationInfo) throws ServiceException, UserException;

}
