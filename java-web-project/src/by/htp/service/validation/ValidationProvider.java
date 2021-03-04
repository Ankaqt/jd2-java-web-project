package by.htp.service.validation;

import by.htp.service.validation.impl.LoginationValidatorImpl;
import by.htp.service.validation.impl.RegistrationValidatorImpl;

public class ValidationProvider {

	private static ValidationProvider instance = new ValidationProvider();

	private ValidationProvider() {

	}

	private final LoginationValidatorImpl loginationValidatorImpl = new LoginationValidatorImpl();
	private final RegistrationValidatorImpl registrationValidatorImpl = new RegistrationValidatorImpl();

	public static ValidationProvider getInstance() {
		return instance;
	}

	public LoginationValidatorImpl getLoginValidatorImpl() {
		return loginationValidatorImpl;
	}

	public RegistrationValidatorImpl getRegistrationValidatorImpl() {
		return registrationValidatorImpl;
	}

}
