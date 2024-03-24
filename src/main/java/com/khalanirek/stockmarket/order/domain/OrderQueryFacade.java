package com.khalanirek.stockmarket.order.domain;

import com.khalanirek.stockmarket.order.dto.OrderDto;
import com.khalanirek.stockmarket.order.dto.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryFacade {
    
    private final OrderRepository orderRepository;
    
    public OrderDto.Order findOrderById(OrderId orderId) {
        return orderRepository.findById(orderId.getId())
                .orElseThrow()
                .toDto();
    }
    
}
