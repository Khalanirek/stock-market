package com.khalanirek.stockmarket.order.infrastructure;

import com.khalanirek.stockmarket.order.domain.OrderQueryFacade;
import com.khalanirek.stockmarket.order.dto.OrderApi;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import com.khalanirek.stockmarket.order.dto.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderQueryController {

    private final OrderQueryFacade orderQueryFacade;

    @GetMapping("/{orderId}")
    public OrderApi.OrderDetails getOrderDetails(@PathVariable UUID orderId) {
        OrderDto.Order order = orderQueryFacade.findOrderById(OrderId.of(orderId));
        return OrderApiAdapter.DtoToApi.toOrderDetails(order);
    }

}
