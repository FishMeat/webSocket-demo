package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shangguanguangbo
 * @since 10.11.2016
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/testWebSocket")
    public String handle(String greeting) {
        return "[" + System.currentTimeMillis() + "]: " + greeting;
    }

    @RequestMapping(path="/greeting")
    @ResponseBody
    public void greet(String greeting) {
        String text = "[" +  System.currentTimeMillis() + "]:" + greeting;
        this.simpMessagingTemplate.convertAndSend("/topic/testWebSocket", text);
    }


}
