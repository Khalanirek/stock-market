package com.khalanirek.stockmarket.order.infrastructure;

import com.khalanirek.stockmarket.order.domain.OrderCommandFacade;
import com.khalanirek.stockmarket.order.dto.OrderApi;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderCommandController {

    private final OrderCommandFacade orderCommandFacade;

    @PostMapping
    public UUID submitOrder(@RequestBody OrderApi.SubmitOrderRequest request) {
        OrderDto.SubmitOrder submitOrder = OrderApiAdapter.ApiToDto.toSubmitOrder(request);
        return orderCommandFacade.submitOrder(submitOrder).getId();
    }

}
