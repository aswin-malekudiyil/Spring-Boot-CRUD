package com.aswinmalekudiyil.SpringBootCRUD.Controllers;

import com.aswinmalekudiyil.SpringBootCRUD.Entity.User;
import com.aswinmalekudiyil.SpringBootCRUD.Event.RegistrationCompleteEvent;
import com.aswinmalekudiyil.SpringBootCRUD.Model.UserModel;
import com.aswinmalekudiyil.SpringBootCRUD.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                "url"
        ));
        return "Success";
    }
}
