package com.example.bookstore.service;


import com.example.bookstore.model.Book;
import com.example.bookstore.model.Order;
import com.example.bookstore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final BookService bookService;

    private final OrderRepository orderRepository;

    public Order putAnOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList
                .stream()
                .map(bookService::findBookById).collect(Collectors.toList());


        Double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(book -> book.getPrice()).orElse((0.0)))
                .reduce(0.0, Double::sum);

        Order order = Order.builder()
                .totalPrice(totalPrice)
                .userName(userName)
                .build();

        return orderRepository.save(order);
    }
}
