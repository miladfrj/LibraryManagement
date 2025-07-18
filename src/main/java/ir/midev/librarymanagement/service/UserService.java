package ir.midev.librarymanagement.service;


import ir.midev.librarymanagement.dto.request.UserRequest;
import ir.midev.librarymanagement.dto.response.UserResponse;

public interface UserService {

    UserResponse save(UserRequest userRequest);

}
