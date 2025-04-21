package com.prac.pracproj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.pracproj.Domain.User;
import com.prac.pracproj.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public User validate(String username,String password){
        return repo.findByUsernameAndPassword(username,password);
    }
}
