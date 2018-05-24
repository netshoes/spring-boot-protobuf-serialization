package com.article.springbootserializationproducer.gateway;

import com.article.springbootserialization.proto.OrdersProto;
import com.article.springbootserializationproducer.domain.Order;

import java.util.Collection;

public interface OrderGateway {

    Collection<Order> regularOrders(int totalElements);
    OrdersProto.Orders protobufOrders(int totalElements);
}
