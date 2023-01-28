package com.chatgptservice.microservice_chatgpt.repository;

import com.chatgptservice.microservice_chatgpt.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {

}
