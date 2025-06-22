// A simple RESTful Order Service using Spring Boot
// - Base path: /abc
// - POST /add: Number of orders to be added
// - GET /get: Returns all stored orders as a JSON array

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class OrderService {

    static class Order {
        public int id;
        public String item;
    }

    private final List<Order> orders = new ArrayList<>();

    // POST /orders/add
    // Adds a new order from the request body
    // Input: JSON { "id": int, "name": string }
    // Output: Status of the order
    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        orders.add(order);
        return "Order added successfully";
    }

    // GET /orders/get
    // Returns all added orders
    // Input: none
    // Output: List of orders in JSON format
    @GetMapping("/get")
    public List<Order> getOrders() {
        return [];
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderService.class, args);
    }
}
