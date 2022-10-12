package com.example.bookstore.controller;


import com.example.bookstore.dto.BookOrderRequest;
import com.example.bookstore.model.Order;
import com.example.bookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookstore")
@RequiredArgsConstructor
public class BookStoreController {

    private final OrderService orderService;


    @GetMapping
    public ResponseEntity<String> helloTwitch() {
        return ResponseEntity.ok("Hello Twitch");
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }
}
