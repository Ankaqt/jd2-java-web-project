package by.htp.service.impl;

import by.htp.bean.User;
import by.htp.bean.RegistrationInfo;
import by.htp.dao.DAOException;
import by.htp.dao.DAOProvider;
import by.htp.dao.UserDAO;
import by.htp.service.ServiceException;
import by.htp.service.UserService;
import by.htp.service.validation.LoginationValidator;
import by.htp.service.validation.RegistrationValidator;
import by.htp.service.validation.ValidationProvider;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String name, String password) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserdao();

		ValidationProvider validationProvider = ValidationProvider.getInstance();
		LoginationValidator loginationValidator = validationProvider.getLoginValidator();

		User user = null;

		if (loginationValidator.checkLogination(name, password)) {
			try {
				user = userDAO.authorization(name, password);
			} catch (DAOException e) {
				throw new ServiceException("dao error", e);
			}
		}

		return user;
	}

	@Override
	public boolean registrate(RegistrationInfo registrationInfo) throws ServiceException {

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
			throw new ServiceException("user didn't registrate");
		}

	}
}
