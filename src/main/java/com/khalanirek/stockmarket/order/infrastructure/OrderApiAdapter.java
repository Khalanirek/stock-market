package com.khalanirek.stockmarket.order.infrastructure;

import com.khalanirek.stockmarket.company.dto.CompanyId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import com.khalanirek.stockmarket.order.dto.OrderApi;
import com.khalanirek.stockmarket.order.dto.OrderDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class OrderApiAdapter {

    static class ApiToDto {

        static OrderDto.SubmitOrder toSubmitOrder(OrderApi.SubmitOrderRequest request) {
            return OrderDto.SubmitOrder.builder()
                    .investorId(InvestorId.of(request.getInvestorId()))
                    .orderType(request.getOrderType())
                    .share(toShare(request.getShare()))
                    .expirationTime(request.getExpirationTime())
                    .build();
        }

        private static OrderDto.Share toShare(OrderApi.Share share) {
            return OrderDto.Share.builder()
                    .companyId(CompanyId.of(share.getCompanyId()))
                    .quantity(share.getQuantity())
                    .price(share.getPrice())
                    .build();
        }

    }

    static class DtoToApi {

        static OrderApi.OrderDetails toOrderDetails(OrderDto.Order dto) {
            return OrderApi.OrderDetails.builder()
                    .id(dto.getId().getId())
                    .investorId(dto.getInvestorId().getId())
                    .orderType(dto.getOrderType())
                    .share(toShare(dto.getShare()))
                    .expirationTime(dto.getExpirationTime())
                    .build();
        }

        private static OrderApi.Share toShare(OrderDto.Share dto) {
            return OrderApi.Share.builder()
                    .companyId(dto.getCompanyId().getId())
                    .quantity(dto.getQuantity())
                    .price(dto.getPrice())
                    .build();
        }

    }

}
