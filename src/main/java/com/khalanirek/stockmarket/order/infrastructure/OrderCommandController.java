package com.khalanirek.stockmarket.order.infrastructure;

import com.khalanirek.stockmarket.order.domain.OrderCommandFacade;
import com.khalanirek.stockmarket.order.dto.OrderApi;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderCommandController {

    private final OrderCommandFacade orderCommandFacade;

    @PostMapping
    @ResponseStatus(CREATED)
    public UUID submitOrder(@RequestBody OrderApi.SubmitOrderRequest request) {
        OrderDto.SubmitOrder submitOrder = OrderApiAdapter.ApiToDto.toSubmitOrder(request);
        return orderCommandFacade.submitOrder(submitOrder).getId();
    }

}
