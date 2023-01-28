package com.chatgptservice.microservice_chatgpt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ChatMessage {
    @Id
    private Long id;
    private String question;
    private String response;


   }
