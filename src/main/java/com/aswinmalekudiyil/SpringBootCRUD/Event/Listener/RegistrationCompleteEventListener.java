package com.aswinmalekudiyil.SpringBootCRUD.Event.Listener;

import com.aswinmalekudiyil.SpringBootCRUD.Entity.User;
import com.aswinmalekudiyil.SpringBootCRUD.Event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        //verification token for the user link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();

        //Send mail to the user
    }
}
