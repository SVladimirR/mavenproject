package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class BookServiceTest {
    @Test
    void calculateTotalPrice() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 50, true, LocalDate.now()));
        products.add(new Product("Book", 80, false, LocalDate.now()));
        products.add(new Product("Book", 70, true, LocalDate.now()));
        products.add(new Product("Shirt", 30, true, LocalDate.now()));

        double totalPrice = BookService.calculateTotalPrice(products, 75);
        Assertions.assertEquals(120, totalPrice);
    }

    @Test
    void getLatestProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 50, true, LocalDate.now().minusDays(3)));
        products.add(new Product("Book", 80, false, LocalDate.now().minusDays(2)));
        products.add(new Product("Book", 70, true, LocalDate.now().minusDays(1)));

        List<Product> latestProducts = BookService.getLatestProducts(products, 2);
        Assertions.assertEquals(2, latestProducts.size());
        Assertions.assertEquals("Book", latestProducts.get(0).getType());
        Assertions.assertEquals("Book", latestProducts.get(1).getType());
    }

    @Test
    void getCheapestBook() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 50, true, LocalDate.now()));
        products.add(new Product("Book", 80, false, LocalDate.now()));
        products.add(new Product("Book", 70, true, LocalDate.now()));

        Product cheapestBook = BookService.getCheapestBook(products);
        Assertions.assertEquals("Book", cheapestBook.getType());
        Assertions.assertEquals(50, cheapestBook.getPrice());
    }

    @Test
    void getDiscountedBooks() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 50, true, LocalDate.now()));
        products.add(new Product("Book", 80, false, LocalDate.now()));
        products.add(new Product("Book", 70, true, LocalDate.now()));
        products.add(new Product("Shirt", 30, true, LocalDate.now()));

        double discount = 10;
        List<Product> discountedBooks = BookService.getDiscountedBooks(products, discount);
        Assertions.assertEquals(2, discountedBooks.size());

        for (Product product : discountedBooks) {
            Assertions.assertEquals("Book", product.getType());
            double originalPrice = product.getPrice() / (1 - discount / 100);
            Assertions.assertEquals(originalPrice * 0.9, product.getPrice(), 0.001);
        }
    }

    @Test
    void getExpensiveBooks() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 300, true, LocalDate.now()));
        products.add(new Product("Book", 150, true, LocalDate.now()));
        products.add(new Product("Book", 350, true, LocalDate.now()));
        products.add(new Product("Shirt", 30, true, LocalDate.now()));

        List<Product> expensiveBooks = BookService.getExpensiveBooks(products);
        Assertions.assertEquals(2, expensiveBooks.size());
        for (Product product : expensiveBooks) {
            Assertions.assertEquals("Book", product.getType());
            Assertions.assertTrue(product.getPrice() > 250);
        }
    }

    @Test
    void groupByType() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 100, false, LocalDate.now()));
        products.add(new Product("Toy", 200, true, LocalDate.now()));
        products.add(new Product("Book", 150, true, LocalDate.now()));
        products.add(new Product("Toy", 250, false, LocalDate.now()));

        Map<String, List<Product>> groupedProducts = BookService.groupByType(products);

        Assertions.assertEquals(2, groupedProducts.size());
        Assertions.assertTrue(groupedProducts.containsKey("Book"));
        Assertions.assertTrue(groupedProducts.containsKey("Toy"));

        List<Product> bookProducts = groupedProducts.get("Book");
        Assertions.assertEquals(2, bookProducts.size());
        Assertions.assertEquals("Book", bookProducts.get(0).getType());
        Assertions.assertEquals("Book", bookProducts.get(1).getType());

        List<Product> toyProducts = groupedProducts.get("Toy");
        Assertions.assertEquals(2, toyProducts.size());
        Assertions.assertEquals("Toy", toyProducts.get(0).getType());
        Assertions.assertEquals("Toy", toyProducts.get(1).getType());
    }

}