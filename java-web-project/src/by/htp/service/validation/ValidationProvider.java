package by.htp.service.validation;

import by.htp.service.validation.impl.LoginationValidatorImpl;
import by.htp.service.validation.impl.NewsModifyValidatorImpl;
import by.htp.service.validation.impl.RegistrationValidatorImpl;

public class ValidationProvider {

	private static ValidationProvider instance = new ValidationProvider();

	private ValidationProvider() {

	}

	private final LoginationValidator loginationValidator = new LoginationValidatorImpl();
	private final RegistrationValidator registrationValidator = new RegistrationValidatorImpl();
	private final NewsModifyValidator newsModifyValidator = new NewsModifyValidatorImpl();

	public static ValidationProvider getInstance() {
		return instance;
	}

	public LoginationValidator getLoginValidator() {
		return loginationValidator;
	}

	public RegistrationValidator getRegistrationValidator() {
		return registrationValidator;
	}

	public NewsModifyValidator getNewsModifyValidator() {
		return newsModifyValidator;

	}

}
