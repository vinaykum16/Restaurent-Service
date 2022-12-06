package com.ordermanagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.ordermanagement.entity.FoodItem;
import com.ordermanagement.entity.OrderDetails;
import com.ordermanagement.entity.UserInfo;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.service.impl.OrderServiceImpl;

@SpringBootTest
class OrderManagementApplicationTests {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderServiceImpl orderService;
	
	    private final long restaurantId = 11111;
	    private final long id = 101;
	    private final long paymentId = 22331;
	    private UserInfo userInfo;

	    @Before
	    public void setupMock() {
	        orderRepository = mock(OrderRepository.class);
	        orderService = new OrderServiceImpl(orderRepository);
	        userInfo = new UserInfo();
	        userInfo.setFullName("YourName");
	        userInfo.setMobile("14081234567");
	    }

	    @Test
	    public void whenCreateOrder_returnCreatedOrder() {
	        List<FoodItem> foodItems = new ArrayList<>();
	        foodItems.add(generateFoodItem(2,"Cake", 150, 5));
	        foodItems.add(generateFoodItem(1,"Pizza", 100, 3));
	        OrderDetails order = generateOrder(id, restaurantId, foodItems, paymentId, userInfo);
	        when(orderRepository.save(order)).thenReturn(order);

	        OrderDetails savedOrder = orderService.addNewOrder(order);
	        assertThat(savedOrder.getTotalPrice()).isEqualTo(2 * 11 + 3 * 12);
	    }

	    private OrderDetails generateOrder(long id, long restaurantId, List<FoodItem> items, long paymentId,  UserInfo userInfo) {
	    	OrderDetails order = new OrderDetails();
	    	order.setId(id);
	        order.setRestaId(restaurantId);
	        order.setFoodItems(items);
	        order.setPaymentId(paymentId);
	        order.setUserinfo(userInfo);
	        return order;
	    }


	    private FoodItem generateFoodItem(long id, String name, int price, int quantity) {
	        FoodItem foodItem = new FoodItem();
	        foodItem.setId(id);
	        foodItem.setName(name);
	        foodItem.setPrice(price);
	        foodItem.setQuantity(quantity);
	        return foodItem;
	    }
}
