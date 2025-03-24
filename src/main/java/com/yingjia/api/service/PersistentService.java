package com.yingjia.api.service;

import com.yingjia.api.entity.User;
import com.yingjia.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistentService {

    private UserRepository userRepository;

    @Autowired
    public PersistentService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public int saveUser(User user) {
        userRepository.save(user);

        return 1;
    }
    public UserRepository getRepo(){
        return userRepository;
    }
}
