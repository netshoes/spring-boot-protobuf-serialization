package com.article.springbootserializationconsumer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {

    GIFT(0),
    COMMON(1);
    private int type;
}
