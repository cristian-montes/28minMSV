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

    static {
        users.add(new User(1,"Carlos", LocalDateTime.now().minusYears(30)));
        users.add(new User(2,"Cierra", LocalDateTime.now().minusYears(20)));
        users.add(new User(3,"Cristian", LocalDateTime.now().minusYears(15)));
    }

    //public List<User> findAll();
    public List<User> findAll(){
        return users;
    }
    //public User save(User user)

    //todo LOOK AT THE FUNCTIONAL PROGRAMMING VIDEO TO UNDERSTAND MORE THE BELOW
    public User findOne(int id){
        Predicate<? super  User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }



}
