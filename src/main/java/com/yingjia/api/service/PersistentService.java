package com.yingjia.api.service;

import com.yingjia.api.entity.Profiles;
import com.yingjia.api.entity.User;
import com.yingjia.api.repo.ProfilesRepository;
import com.yingjia.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersistentService {

    private UserRepository userRepository;
    private ProfilesRepository profilesRepository;

    @Autowired
    public PersistentService(UserRepository userRepository, ProfilesRepository profilesRepository) {
        this.userRepository = userRepository;
        this.profilesRepository = profilesRepository;
    }
    public int saveUser(User user) {
        userRepository.save(user);

        return 1;
    }
    public UserRepository getRepo(){
        return userRepository;
    }

    public int saveProfile(Profiles profiles) {
        profilesRepository.save(profiles);
        return 1;
    }
    public Optional<Profiles> getProfile(String id) {
        return profilesRepository.findById(id);
    }

}
