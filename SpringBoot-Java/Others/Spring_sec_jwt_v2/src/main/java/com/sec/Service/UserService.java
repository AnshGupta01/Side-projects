package com.sec.Service;

import com.sec.Entity.User;
import com.sec.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers(){

        return userRepo.findAll();
    }

    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

//    public UserService(){
//        store.add(new User(UUID.randomUUID().toString(),"Ansh Gupta","Anshg2003@Gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Vansh Gupta","Vansh@Gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Aman Chopra","Aman@Gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Parth Devanshi","Amy@Gmail.com"));
//    }
}
