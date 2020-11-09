package com.harry.springboot.service;


import org.springframework.stereotype.Service;

@Service //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        System.out.println("8002");
        return "《厉害了，我的国》";
    }
}
