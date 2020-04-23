package com.gavintravelling.app.rest;

import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceAlreadyExistException;
import com.gavintravelling.app.exceptionHandling.exeption.ResourceNotFoundException;
import com.gavintravelling.app.modelDto.RegisterForm;
import com.gavintravelling.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/rest")
public class RegisterController {

    @Autowired
    private UserService userService;


    public RegisterController() {
    }


    @PostMapping(value = "/register")
    public ResponseEntity<Customer> register(@Valid @ModelAttribute("register") RegisterForm registerForm,
                              BindingResult result) throws BindException, ResourceAlreadyExistException {
        if(result.hasErrors()){
          throw  new BindException(result);
        }


        if(userService.customerExists(registerForm.geteMail())){
           throw  new ResourceAlreadyExistException(registerForm.geteMail() + ": Already in use ");
        }else{
            var newUser = new Customer(registerForm.getFirstName(),registerForm.getLastName(),registerForm.getPhoneNumber(),
                    registerForm.geteMail(), registerForm.getPersonNumber(), registerForm.getPassword());

            return  ResponseEntity.ok(userService.RegisterUser(newUser));
        }

}





}
