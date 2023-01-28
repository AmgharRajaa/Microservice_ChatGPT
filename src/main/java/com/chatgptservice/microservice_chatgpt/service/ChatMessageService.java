package com.chatgptservice.microservice_chatgpt.service;

import com.chatgptservice.microservice_chatgpt.model.ChatMessage;
import java.util.List;

public interface ChatMessageService {
    void addMessage(ChatMessage chatMessage);
    List< ChatMessage > getMessageOfList();
}
