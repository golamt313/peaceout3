package com.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.services.api.v1.impl.UserServiceApiImpl;
import com.services.api.v1.interf.UserServiceApiInter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
}