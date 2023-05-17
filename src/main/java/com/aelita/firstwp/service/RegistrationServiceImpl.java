package com.aelita.firstwp.service;

import com.aelita.firstwp.exception.WrongLoginException;
import com.aelita.firstwp.exception.WrongPasswordException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service

public class RegistrationServiceImpl implements RegistrationService {

    //(?=.*[A-Z])(?=.*[0-9_])
    public String hello(String login, String password, String confirmPassword) throws WrongLoginException {
        String pat = "^[A-Za-z0-9_]";
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(login);
        Matcher matcher2 = pattern.matcher(password);
        String answer = "";
        String answer2 = "";
        String answer3 = "";

        if (login.length() >= 20) {
            throw new WrongLoginException("Больше 20 символов");
        } else if (matcher.matches() == true) {
            answer = "Победа!";
        } else {
            answer = "";
        }


        if (password.length() >= 20) {
            answer2 = "Количество символов больше 20";
        } else if (matcher2.matches() == true) {
            answer2 = "Победа!";
        } else {
            answer2 = "";
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        } else {
            answer3 = "Победа!";
        }

        return answer + " " + answer2 + " " + answer3;
    }

}
