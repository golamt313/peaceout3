package com.services.api.v1.interf;
import com.services.api.v1.models.UserRequest;
import java.io.IOException;
import retrofit2.http.Body;

public interface UserServiceApiInter {
   UserRequest getUserAllUsers() throws IOException;
   UserRequest updateUserById(@Body UserRequest userRequest) throws IOException;
}
