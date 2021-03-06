package com.example.ase2demoproject;

import com.example.ase2demoproject.web.stomp.MyStompSessionHandler;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

/**
 * Stand alone WebSocketStompClient.
 */
public class StompClient {
    public static void main(String[] args) {
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        String URL = "ws://localhost:8080/broadcast";
        stompClient.connect(URL, sessionHandler);
        // Don't close immediately - Type <Enter> to exit
        new Scanner(System.in).nextLine();
    }
}
