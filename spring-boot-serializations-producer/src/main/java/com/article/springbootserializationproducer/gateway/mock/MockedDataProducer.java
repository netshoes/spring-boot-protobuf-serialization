package com.article.springbootserializationproducer.gateway.mock;

import com.article.springbootserializationproducer.domain.Order;
import com.article.springbootserializationproducer.domain.ProductType;
import com.article.springbootserializationproducer.gateway.OrderGateway;
import com.article.springbootserialization.proto.OrdersProto;
import com.article.springbootserializationproducer.domain.Person;
import com.article.springbootserializationproducer.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@Service
public class MockedDataProducer implements OrderGateway {
    private static final int PRICE_IN_CENTS = 100000;
    private static final int INITIAL_ORDER_ID = 10000000;
    private static final String PERSON_NAME = "John Conceição";
    private static final String ID_PRODUCT_1 = "XXX-2121-333-11";
    private static final String ID_PRODUCT_2 = "YYY-3333-121-21";
    private static final String ID_PRODUCT_3 = "941-6957-219-41";

    @Override
    public Collection<Order> regularOrders(int totalElements) {
        final Collection<Order> orderCollection = new ArrayList<>(totalElements);

        IntStream.range(0, totalElements)
                .forEach(
                        iteration -> {
                            final Product product1 =
                                    Product.builder()
                                            .id(ID_PRODUCT_1)
                                            .productType(ProductType.COMMON)
                                            .priceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final Product product2 =
                                    Product.builder()
                                            .id(ID_PRODUCT_2)
                                            .productType(ProductType.COMMON)
                                            .priceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final Product product3 =
                                    Product.builder()
                                            .id(ID_PRODUCT_3)
                                            .productType(ProductType.COMMON)
                                            .priceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final Person person = Person.builder().name(PERSON_NAME).build();

                            final Order order =
                                    Order.builder()
                                            .orderId(String.valueOf(INITIAL_ORDER_ID + iteration))
                                            .person(person)
                                            .productCollection(Arrays.asList(product1, product2, product3))
                                            .build();
                            orderCollection.add(order);
                        });

        return orderCollection;
    }

    @Override
    public OrdersProto.Orders protobufOrders(int totalElements) {
        final OrdersProto.Orders.Builder orders = OrdersProto.Orders.newBuilder();

        IntStream.range(0, totalElements)
                .forEach(
                        iteration -> {
                            final OrdersProto.Product product1 =
                                    OrdersProto.Product.newBuilder()
                                            .setId(ID_PRODUCT_1)
                                            .setProductType(OrdersProto.Product.ProductType.COMMON)
                                            .setPriceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final OrdersProto.Product product2 =
                                    OrdersProto.Product.newBuilder()
                                            .setId(ID_PRODUCT_2)
                                            .setProductType(OrdersProto.Product.ProductType.COMMON)
                                            .setPriceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final OrdersProto.Product product3 =
                                    OrdersProto.Product.newBuilder()
                                            .setId(ID_PRODUCT_3)
                                            .setProductType(OrdersProto.Product.ProductType.GIFT)
                                            .setPriceInCents(new Random().nextInt(PRICE_IN_CENTS))
                                            .build();

                            final OrdersProto.Person person = OrdersProto.Person.newBuilder().setName(PERSON_NAME).build();

                            final OrdersProto.Order order =
                                    OrdersProto.Order.newBuilder()
                                            .setOrderId(String.valueOf(INITIAL_ORDER_ID + iteration))
                                            .setPerson(person)
                                            .addProduct(product1)
                                            .addProduct(product2)
                                            .addProduct(product3)
                                            .build();
                            orders.addOrders(order);
                        });

        return orders.build();
    }
}
