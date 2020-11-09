package com.harry.springboot.controller;

import com.harry.springboot.client.TicketClient;
import com.harry.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/getTicket")
    public String getTicker(){
        System.out.println(ticketService);
        String ticket = ticketService.getTicket();
        return ticket;
    }
}
