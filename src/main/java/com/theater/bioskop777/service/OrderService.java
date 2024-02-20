package com.theater.bioskop777.service;

import com.theater.bioskop777.dto.request.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface OrderService {

    public ResponseEntity<?> orderTicket(OrderRequest orderRequest);

}
