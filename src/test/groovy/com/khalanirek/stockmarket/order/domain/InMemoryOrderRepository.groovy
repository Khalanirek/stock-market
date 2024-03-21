package com.khalanirek.stockmarket.order.domain

import com.khalanirek.stockmarket.common.InMemoryBaseRepository

class InMemoryOrderRepository extends InMemoryBaseRepository<Order> implements OrderRepository {
}
