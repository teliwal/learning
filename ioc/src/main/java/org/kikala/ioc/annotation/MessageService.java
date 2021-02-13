package org.kikala.ioc.annotation;

@Composant
public class MessageService {

    public void print(String message) {
        System.out.println("[Message Service], " + message);
    }
}
