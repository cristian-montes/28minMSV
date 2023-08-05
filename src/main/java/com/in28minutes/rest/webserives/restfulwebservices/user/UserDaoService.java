package com.in28minutes.rest.webserives.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //JPA/Hibernate > Database
    //UserDaoService > Static List

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount,"Carlos", LocalDateTime.now().minusYears(30)));
        users.add(new User(++usersCount,"Cierra", LocalDateTime.now().minusYears(20)));
        users.add(new User(++usersCount,"Cristian", LocalDateTime.now().minusYears(15)));
    }

    //public List<User> findAll();
    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    //todo LOOK AT THE FUNCTIONAL PROGRAMMING VIDEO TO UNDERSTAND MORE THE BELOW
    public User findOne(int id){
        Predicate<? super  User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User delteById(int id){
        Predicate<? super  User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }


}
