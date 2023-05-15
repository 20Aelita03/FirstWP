package com.aelita.firstwp.service;

import com.aelita.firstwp.exception.WrongLoginException;

public interface RegistrationService {
        String hello(String login, String password, String confirmPassword) throws WrongLoginException;


}
