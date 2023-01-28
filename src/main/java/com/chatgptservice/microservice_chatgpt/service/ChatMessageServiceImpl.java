package com.chatgptservice.microservice_chatgpt.service;

import com.chatgptservice.microservice_chatgpt.model.ChatMessage;
import com.chatgptservice.microservice_chatgpt.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService{

    @Autowired
    ChatMessageRepository chatMessageRepository;
    @Override
    public void addMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }
    @Override
    public List<ChatMessage> getMessageOfList() {
        return chatMessageRepository.findAll();
    }
}
