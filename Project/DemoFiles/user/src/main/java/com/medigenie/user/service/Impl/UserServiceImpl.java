package com.medigenie.user.service.Impl;

import com.medigenie.user.constant.UserConstants;
import com.medigenie.user.dto.UserDTO;
import com.medigenie.user.enums.Status;
import com.medigenie.user.exception.UserException;
import com.medigenie.user.model.User;
import com.medigenie.user.repository.UserRepository;
import com.medigenie.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${microservices.endpoint.user.dummyEndpoint}")
    private String dummyEndpoint;

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public void save(UserDTO userDTO) {
        User user = new User();
        if(userDTO != null) {
            BeanUtils.copyProperties(userDTO,user);
            userRepository.save(user);
        }
        else {
            throw new UserException(UserConstants.SAVE_FAILURE);
        }
    }

    @Override
    public UserDTO findById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(optionalUser.get(),userDTO);
            return userDTO;
        }
        else {
            throw new UserException(UserConstants.USER_FETCHED_FAILURE);
        }

    }

    @Override
    public UserDTO findByIdAndStatus(long id, Status status) {
        Optional<User> optionalUser = userRepository.findByIdAndStatus(id,status);
        if(optionalUser.isPresent()) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(optionalUser.get(),userDTO);
            return userDTO;
        }
        else {
            throw new UserException(UserConstants.USER_FETCHED_FAILURE);
        }

    }

    @Override
    public UserDTO findByEmailAndStatus(String email, Status status) {
        Optional<User> optionalUser = userRepository.findByEmailAndStatus(email,status);
        if(optionalUser.isPresent()) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(optionalUser.get(),userDTO);
            return userDTO;
        }
        else {
            throw new UserException(UserConstants.USER_FETCHED_FAILURE);
        }
    }


    @Override
    public UserDTO findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(optionalUser.get(),userDTO);
            return userDTO;
        }
        else {
            throw new UserException(UserConstants.USER_FETCHED_FAILURE);
        }

    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        if(!users.isEmpty()) {
            users.forEach(e->{
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(e,userDTO);
                userDTOS.add(userDTO);
            });
            return userDTOS;
        }
        else {
            throw new UserException(UserConstants.USER_FETCHED_FAILURE);
        }

    }

    @Override
    public List<UserDTO> findAllByStatus(Status status) {
        List<User> users = userRepository.findAllByStatus(status);
        List<UserDTO> userDTOS = new ArrayList<>();
        if(!users.isEmpty()) {
            users.forEach(e->{
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(e,userDTO);
                userDTOS.add(userDTO);
            });
            return userDTOS;
        }
        else {
            throw new UserException(UserConstants.USER_FETCHED_FAILURE);
        }
    }

    @Override
    public void deleteUserById(long id) {
        UserDTO userDTO = this.findById(id);
        if(userDTO != null) {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            user.setStatus(Status.DEACTIVATE);
            userRepository.save(user);
        }
        else {
            throw new UserException(UserConstants.USER_FETCHED_FAILURE);
        }
    }

    @Override
    @CircuitBreaker(name = "userService")
    public void dummyRestCall() {
        Object o = restTemplate.postForEntity(dummyEndpoint,new Object(),Object.class);
    }


}
