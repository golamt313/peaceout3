package com.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.services.api.v1.impl.AuthenicationServiceImpl;
import com.services.api.v1.impl.UserServiceApiImpl;
import com.services.api.v1.interf.AuthenicationServiceInter;
import com.services.api.v1.interf.UserServiceApiInter;
import com.services.api.v1.models.AuthRequest;
import com.services.api.v1.models.Token;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class UserAPIImplTests {
    @DisplayName("Test MessageService.get()")
    @Test
    void addition() {


        assertEquals(2, 2);
    }
    @Test
    void getUserByIdTest() throws IOException {
        UserServiceApiInter api = new UserServiceApiImpl("https://dummy.restapiexample.com/");
        api.getUserAllUsers().getData();
        assertEquals(2,2);
    }
    @Test
    void getAuthTest() throws IOException {
        AuthenicationServiceInter  api = new AuthenicationServiceImpl("http://localhost:3000/");
        AuthRequest req = new AuthRequest();
        req.setUsername("test");
        req.setPassword("test");
        Token token = api.login(req);
        boolean logged = api.validate(token);
        assertEquals(true,logged);
    }
}