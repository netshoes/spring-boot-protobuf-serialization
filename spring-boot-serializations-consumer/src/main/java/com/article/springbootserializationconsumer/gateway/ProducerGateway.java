package com.article.springbootserializationconsumer.gateway;

import com.article.springbootserializationconsumer.domain.Order;
import com.article.springbootserialization.proto.OrdersProto;

import java.util.Collection;

public interface ProducerGateway {
    OrdersProto.Orders getOrdersProto(int totalElements);

    Collection<Order> getOrders(int totalElements);
}
