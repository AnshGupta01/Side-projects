package com.sec.Service;

import com.sec.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Ansh Gupta","Anshg2003@Gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Vansh Gupta","Vansh@Gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Aman Chopra","Aman@Gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Parth Devanshi","Amy@Gmail.com"));
    }

    public List<User> getUsers(){
        return this.store;
    }

}
