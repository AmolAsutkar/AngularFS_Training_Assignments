package com.medigenie.user.service;

import com.medigenie.user.dto.UserDTO;
import com.medigenie.user.enums.Status;

import java.util.List;

public interface UserService {

    void save(UserDTO userDTO);

    UserDTO findById(long id);

    UserDTO findByIdAndStatus(long id, Status status);

    UserDTO findByEmailAndStatus(String email, Status status);


    UserDTO findByEmail(String email);

    List<UserDTO> findAll();
    List<UserDTO> findAllByStatus(Status status);

    void deleteUserById(long id);

    void dummyRestCall();




}
