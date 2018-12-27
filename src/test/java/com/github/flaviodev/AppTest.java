package com.github.flaviodev;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.flaviodev.model.Order;

public class AppTest {

	private Logger logger = LoggerFactory.getLogger(AppTest.class);

	@Test
	public void shouldntHasNotDeliveredOrders() {
		List<Order> orders = new ArrayList<>();
		boolean hasNotDeliveredOrders = orders.stream().anyMatch(order -> order.isNotDelivered());
		logger.info("shouldntHasNotDeliveredOrders -> expected: false and was: {}", hasNotDeliveredOrders);
		assertFalse(hasNotDeliveredOrders);
	}
}
