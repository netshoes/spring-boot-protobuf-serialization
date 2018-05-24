package com.article.springbootserializationproducer.usecase;

import com.article.springbootserializationproducer.domain.Order;
import com.article.springbootserializationproducer.gateway.OrderGateway;
import com.article.springbootserialization.proto.OrdersProto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderGateway orderGateway;

    public Collection<Order> getOrders(int totalElements) {
        return orderGateway.regularOrders(totalElements);
    }

    public OrdersProto.Orders getProtobufOrders(int totalElements) {
        return orderGateway.protobufOrders(totalElements);
    }
}
