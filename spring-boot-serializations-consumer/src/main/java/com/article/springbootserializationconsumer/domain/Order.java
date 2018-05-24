package com.article.springbootserializationconsumer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private Person person;
    private Collection<Product> productCollection;
}
