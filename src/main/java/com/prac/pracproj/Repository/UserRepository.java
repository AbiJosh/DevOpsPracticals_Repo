package com.prac.pracproj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.pracproj.Domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsernameAndPassword(String username,String password);
}
