package com.chatgptservice.microservice_chatgpt;

import com.chatgptservice.microservice_chatgpt.model.ChatMessage;
import com.chatgptservice.microservice_chatgpt.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MicroserviceChatgptApplication {
    @Autowired
    private ChatMessageService chatMessageService;
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceChatgptApplication.class, args);
    }


}
