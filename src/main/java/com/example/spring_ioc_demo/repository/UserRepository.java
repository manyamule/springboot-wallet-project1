package com.example.spring_ioc_demo.repository;

import com.example.spring_ioc_demo.entity.UserEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{

}
