package com.example.spring_ioc_demo.service;

import com.example.spring_ioc_demo.entity.UserEntity;
import com.example.spring_ioc_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //comment for git



    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

        System.out.println("UserService object created: "
                + System.identityHashCode(this));
    }

    public void debit(Long senderId, Long amount) {

        UserEntity user = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        if (user.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        user.setBalance(user.getBalance() - amount);


        userRepository.save(user);
    }

    public void credit(Long receiverId, Long amount) {

        UserEntity user = userRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        user.setBalance(user.getBalance() + amount);

        userRepository.save(user);
    }


}