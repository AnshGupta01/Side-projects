package com.project.restservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount,"Ansh", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Aman", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount,"Ez", LocalDate.now().minusYears(10)));
        users.add(new User(++usersCount,"Ez2", LocalDate.now().minusYears(35)));
    }

    public User saveUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
