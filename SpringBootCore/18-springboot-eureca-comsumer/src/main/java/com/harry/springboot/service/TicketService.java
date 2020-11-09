package com.harry.springboot.service;

import com.harry.springboot.client.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketClient ticketClient;

    public String getTicket(){
        return ticketClient.getTicket();
    }
}
