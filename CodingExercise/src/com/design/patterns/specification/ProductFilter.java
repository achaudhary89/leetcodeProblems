package com.design.patterns.specification;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter implements Filter<Product> {
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}
