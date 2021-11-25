package com.services.api.v1.interf;

import com.services.api.v1.models.AuthRequest;
import com.services.api.v1.models.Token;

import java.io.IOException;

public interface AuthenicationServiceInter {
    Token login(AuthRequest userRequest) throws IOException;
    boolean validate(Token token) throws IOException;
    Object getsomething(Token token) throws IOException;
}
