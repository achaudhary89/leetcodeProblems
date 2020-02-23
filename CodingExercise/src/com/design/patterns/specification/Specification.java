package com.design.patterns.specification;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
