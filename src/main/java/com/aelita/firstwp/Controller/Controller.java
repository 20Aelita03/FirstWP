package com.aelita.firstwp.Controller;

import com.aelita.firstwp.exception.WrongLoginException;
import com.aelita.firstwp.exception.WrongPasswordException;
import com.aelita.firstwp.service.RegistrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class Controller {

    private final RegistrationService registrationService;

    public Controller(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping


    public String Hello(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        try {
            return registrationService.hello(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return "Логин не подходит";
        } catch (WrongPasswordException e) {
            return "Пароль не подходит";
        }
    }


}
