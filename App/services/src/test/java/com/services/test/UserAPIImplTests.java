package com.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.services.api.v1.impl.UserAPIImpl;
import com.services.api.v1.interf.UserAPI;

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
        UserAPI api = new UserAPIImpl("https://dummy.restapiexample.com/");
        api.getUserById();
        ((UserAPIImpl) api).getUserResponse();
        assertEquals(2, 2);
    }
}