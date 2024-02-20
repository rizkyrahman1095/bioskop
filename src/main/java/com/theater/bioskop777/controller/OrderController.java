package com.theater.bioskop777.controller;

import com.theater.bioskop777.dto.request.OrderRequest;
import com.theater.bioskop777.service.serviceimpl.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order-ticket")
public class OrderController {

    private OrderServiceImpl service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> orderTicket(@RequestBody OrderRequest request){
        return service.orderTicket(request);
    }

}
