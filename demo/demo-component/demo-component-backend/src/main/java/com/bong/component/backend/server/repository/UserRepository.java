package com.bong.component.backend.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bong.component.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
