package com.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ordermanagement.entity.OrderDetails;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.required.Restaurant;
import com.ordermanagement.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepo) {
		this.orderRepo=orderRepo;
	}

	@Override
	public OrderDetails addNewOrder(OrderDetails newOrder) {
		newOrder.setTotalPrice(newOrder.getFoodItems().stream().mapToInt(e -> e.getPrice()* e.getQuantity()).sum());
		return orderRepo.save(newOrder);
	}

	@Override
	public OrderDetails findOrderDetailsById(long id) {
		return orderRepo.findById(id).orElse(null);
	}

	@Override
	public OrderDetails updateOrderDetailsById(long id, OrderDetails updateOrder) {
		updateOrder.setTotalPrice(updateOrder.getFoodItems().stream().mapToInt(e -> e.getPrice()* e.getQuantity()).sum());
		return orderRepo.save(updateOrder);
	}

	@Override
	public void deleteOrderById(long id) {
		orderRepo.deleteById(id);
	}

	@Override
	public Restaurant getRestaueantDetailsById(long id) {
		Restaurant restaurant = this.restTemplate.getForObject("http://localhost:8081/restaurant/"+id, Restaurant.class);
		return restaurant;
	}



}
