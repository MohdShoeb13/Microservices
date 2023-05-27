package com.practice.microservices.user.service.repository;

import com.practice.microservices.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>
{

}