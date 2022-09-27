package com.medigenie.user.controller;


import com.medigenie.user.constant.UserConstants;
import com.medigenie.user.dto.UserDTO;
import com.medigenie.user.dto.UserResponseDTO;
import com.medigenie.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RefreshScope
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserDTO userDTO) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userService.save(userDTO);
        userResponseDTO.setStatus(HttpStatus.OK);
        userResponseDTO.setMessage(UserConstants.SAVE_SUCCESS);

        return new ResponseEntity<>(userResponseDTO, userResponseDTO.getStatus());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable(name = "id") long id) {


        UserResponseDTO userResponseDTO = new UserResponseDTO();

        UserDTO userDTO = userService.findById(id);
        userResponseDTO.setStatus(HttpStatus.OK);
        userResponseDTO.setMessage(UserConstants.USER_FETCHED);
        userResponseDTO.setData(userDTO);
        return new ResponseEntity<>(userResponseDTO, userResponseDTO.getStatus());
    }

    @PostMapping("/restCall")
    public ResponseEntity<UserResponseDTO> restCall() {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userService.dummyRestCall();
        userResponseDTO.setStatus(HttpStatus.OK);
        userResponseDTO.setMessage(UserConstants.USER_FETCHED);

        return new ResponseEntity<>(userResponseDTO, userResponseDTO.getStatus());
    }

}
