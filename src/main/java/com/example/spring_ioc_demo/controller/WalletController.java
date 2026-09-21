package com.example.spring_ioc_demo.controller;


import com.example.spring_ioc_demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value="/wallet/")

public class WalletController {

    @Autowired
    private WalletService service;

    @PostMapping("/transfer")

    public String transfer(@RequestParam Long senderId,@RequestParam Long receiverId, @RequestParam Long amount)
    {
        try{
            service.transfer(senderId,receiverId,amount);


        } catch (Exception e) {

            return "transfer failed"+e.getMessage();
        }
        return "transfer completed";

    }

    @GetMapping("/balance")
    public Long checkBalance(@RequestParam Long userId) {
        return service.checkBalance(userId);
    }




}

