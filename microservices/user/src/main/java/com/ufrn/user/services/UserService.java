package com.ufrn.user.services;

import com.ufrn.user.dtos.UserDTO;
import com.ufrn.user.models.UserModel;
import com.ufrn.user.producers.UserProducer;
import com.ufrn.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserProducer userProducer;

    @Autowired
    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel saveUser(UserDTO userDTO) {
        UserModel user = new UserModel();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());


        userRepository.save(user);

        userProducer.publishMessageEmail(user);

        return user;
    }
}
