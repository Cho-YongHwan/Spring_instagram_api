package com.instagram.api.service;

import com.instagram.api.domain.entity.UserEntity;
import com.instagram.api.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public List<UserEntity> getUserList() {
        List<UserEntity> list = userRepository.findAll();
        return list;
    }

    public Optional<UserEntity> getUserByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);

        if (user == null) {
            return null;
        }

        System.out.println(user);

        return user;
    }
}
