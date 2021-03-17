package by.htp.service.impl;

import by.htp.bean.User;
import by.htp.bean.RegistrationInfo;
import by.htp.dao.DAOProvider;
import by.htp.dao.UserDAO;
import by.htp.dao.exception.DAOException;
import by.htp.service.UserService;
import by.htp.service.exception.ServiceException;
import by.htp.service.exception.UserException;
import by.htp.service.validation.LoginationValidator;
import by.htp.service.validation.RegistrationValidator;
import by.htp.service.validation.ValidationProvider;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String name, String password) throws ServiceException, UserException {

		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserdao();

		ValidationProvider validationProvider = ValidationProvider.getInstance();
		LoginationValidator loginationValidator = validationProvider.getLoginValidator();

		User user;

		if (loginationValidator.checkLogination(name, password)) {
			try {
				return user = userDAO.authorization(name, password);
			} catch (DAOException e) {
				throw new ServiceException("dao error", e);
			}
		} else {
			throw new UserException("user didn't login");
		}
	}

	@Override
	public boolean registrate(RegistrationInfo registrationInfo) throws ServiceException, UserException {

		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserdao();

		ValidationProvider validationProvider = ValidationProvider.getInstance();
		RegistrationValidator registrationValidator = validationProvider.getRegistrationValidator();

		if (registrationValidator.checkRegistration(registrationInfo)) {
			try {
				return userDAO.registrate(registrationInfo);
			} catch (DAOException e) {
				throw new ServiceException("dao error", e);
			}

		} else {
			throw new UserException("user didn't registrate");
		}

	}
}
