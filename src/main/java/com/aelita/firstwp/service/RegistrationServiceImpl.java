package com.aelita.firstwp.service;

import com.aelita.firstwp.exception.WrongLoginException;
import com.aelita.firstwp.exception.WrongPasswordException;
import org.springframework.stereotype.Service;



@Service

public class RegistrationServiceImpl implements RegistrationService{


    public String hello(String login, String password, String confirmPassword) throws WrongLoginException {
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9_])";
        String answer = "";
        String answer2 = "";
        String answer3 = "";

           if (login.length()>= 20){
               throw new WrongLoginException("Больше 20 символов");
           } else if (!login.matches(pat)) {
               answer = "Логин не действительный";
           }else {
               answer = "Логин действительный";
           }



        if (password.length()>= 20){
            answer2 = "Количество символов больше 20";
        } else if (!login.matches(pat)) {
            answer2 = "Пароль не действительный";
        }else {
            answer2 = "Пароль действительный";
        }

        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        } else {
            answer3 = "Пароли совпадают";
        }

        return answer + " " + answer2 + " " + answer3;
    }

}
