package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.entity.Room;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.modelDto.HotelForm;
import com.gavintravelling.app.modelDto.RegisterForm;
import com.gavintravelling.app.repository.CustomerRepository;
import com.gavintravelling.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/rest/registrera")
public class RegisterController {

    @Autowired
    private UserService userService;


    public RegisterController() {
    }


    @PostMapping
    public ResponseEntity<Customer> filter(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
                              BindingResult result) throws BindException {
        if(result.hasErrors()){
          throw  new BindException(result);
        }

        var newUser = new Customer(registerForm.getFirstName(),registerForm.getLastName(),registerForm.getPhoneNumber(),
                registerForm.geteMail(), registerForm.getPersonNumber(), registerForm.getPassword());
        userService.RegisterUser(newUser);
        return  ResponseEntity.ok(newUser);
}



}
