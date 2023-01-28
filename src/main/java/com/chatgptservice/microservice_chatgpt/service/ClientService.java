package com.chatgptservice.microservice_chatgpt.service;

import com.chatgptservice.microservice_chatgpt.model.request.ClientRequest;
import com.chatgptservice.microservice_chatgpt.model.response.ChatGptResponse;


public interface ClientService {
    ChatGptResponse askQuestion(ClientRequest clientRequest);
}
