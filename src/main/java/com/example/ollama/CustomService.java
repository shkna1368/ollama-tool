package com.example.ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CustomService {
    ChatClient chatClient;
    public CustomService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
public String sendMessage(String message) {

    var response = chatClient
            .prompt()
            .user(message)
            .functions("weatherFunctionCustom","reserveFlight","booksByAuthor","openBankAccount","fundTransfer") // reference by bean name.

            .call()
            .content();


return    response.toString();


}

}
