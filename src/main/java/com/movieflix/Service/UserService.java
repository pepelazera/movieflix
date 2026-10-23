package com.movieflix.Service;

import com.movieflix.Entity.User;
import com.movieflix.Repository.UserRepository;
import com.movieflix.Request.UserRequest;
import com.movieflix.Response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
