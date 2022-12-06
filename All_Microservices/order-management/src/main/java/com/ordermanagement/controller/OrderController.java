package com.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.entity.OrderDetails;
import com.ordermanagement.required.Restaurant;
import com.ordermanagement.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public OrderDetails saveNewOrder(@RequestBody OrderDetails newOrder) {
		return orderService.addNewOrder(newOrder);
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderDetails getOrderDetailsById(@PathVariable("id") long id) {
		return orderService.findOrderDetailsById(id);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderDetails updateOrderById(@PathVariable("id") long id, @RequestBody OrderDetails updateOrder) {
		return orderService.updateOrderDetailsById(id, updateOrder);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOrderById(@PathVariable("id") long id) {
		orderService.deleteOrderById(id);
	}
	
	@GetMapping("/resta/{id}")
	@CircuitBreaker(name = "restaurantCircuitBreaker", fallbackMethod ="restaFallBack" )
	public Restaurant getRestaurantInfoById(@PathVariable("id") long id) {
		return orderService.getRestaueantDetailsById(id);
	}
	
	public Restaurant restaFallBack(long id, Exception e) {
		System.out.println("FallBack Method Called!!!");
		return new Restaurant();
	}

}
