package org.example;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

public class BookService {
    public static List<Product> getExpensiveBooks(List<Product> products, double cost) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > cost)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> products, double disc) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscountApplicable())
                .map(product -> {
                    product.setPrice(product.getPrice() * (1 - disc / 100));
                    return product;
                })
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> products) throws NoSuchElementException {
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено."));
    }

    public static List<Product> getLatestProducts(List<Product> products, int count) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public static double calculateTotalPrice(List<Product> products, double maxPrice) {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                .filter(product -> product.getType().equals("Book") &&
                        product.getPrice() <= maxPrice &&
                        product.getDateAdded().getYear() == currentDate.getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

}
