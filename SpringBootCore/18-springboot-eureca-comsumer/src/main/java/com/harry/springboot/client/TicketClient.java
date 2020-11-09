package com.harry.springboot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "provider-ticket")
@Component
public interface TicketClient {
    @RequestMapping(path = "/ticket", method = RequestMethod.GET)
    String getTicket();
}
