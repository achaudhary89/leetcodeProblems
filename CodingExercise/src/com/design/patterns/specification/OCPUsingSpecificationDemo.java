package com.design.patterns.specification;

import java.util.List;

public class OCPUsingSpecificationDemo {
    public static void main(String[] args) {
        Product tree = new Product("Tree",Color.BLUE,Size.MEDIUM);
        Product house = new Product("House",Color.GREEN,Size.LARGE);
        Product shirt = new Product("Shirt",Color.RED,Size.SMALL);

        List<Product> products = List.of(tree,house,shirt);
        ProductFilter filter = new ProductFilter();
       // filter.filter(products, new ProductFilter())

    }
}
