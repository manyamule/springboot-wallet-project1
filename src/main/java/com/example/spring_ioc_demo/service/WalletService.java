package com.example.spring_ioc_demo.service;

import com.example.spring_ioc_demo.entity.UserEntity;
import com.example.spring_ioc_demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final UserService userService;
    private final UserRepository userRepository;

    public WalletService(UserService userService,
                         UserRepository userRepository) {

        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Transactional
    public void transfer(Long senderId, Long receiverId, Long amount) {

        userService.debit(senderId, amount);

        userService.credit(receiverId, amount);
    }

    public Long checkBalance(Long userId) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getBalance();
    }
}