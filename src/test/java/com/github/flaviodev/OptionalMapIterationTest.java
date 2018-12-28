package com.github.flaviodev;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.flaviodev.model.Order;
import com.github.flaviodev.model.OrderItem;
import com.github.flaviodev.model.Product;

public class OptionalMapIterationTest {

	private Logger logger = LoggerFactory.getLogger(OptionalMapIterationTest.class);

	@Test
	public void shouldTotalValueZeroWhenItemsIsNull() {

		Order order = new Order();
		BigDecimal totalValue = order.getTotalValue();

		logger.info("shouldTotalValueZeroWhenItemsIsNull -> expected: 0 and was: {}", totalValue);
		assertEquals(BigDecimal.ZERO, totalValue);
	}

	@Test
	public void shouldTotalValueZeroWhenItemsIsEmpty() {

		Order order = new Order();
		order.setItems(new ArrayList<>());
		BigDecimal totalValue = order.getTotalValue();

		logger.info("shouldTotalValueZeroWhenItemsIsEmpty -> expected: 0 and was: {}", totalValue);
		assertEquals(BigDecimal.ZERO, totalValue);
	}

	@Test
	public void shouldTotalValueZeroWhenHasOneItemWithoutPrice() {

		Product product = new Product();
		
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(product);
		
		List<OrderItem> items = new ArrayList<>();
		items.add(orderItem);

		Order order = new Order();
		order.setItems(items);
		BigDecimal totalValue = order.getTotalValue();

		logger.info("shouldTotalValueZeroWhenHasOneItemWithoutPrice -> expected: 0 and was: {}", totalValue);
		assertEquals(BigDecimal.ZERO, totalValue);
	}

	@Test
	public void shouldTotalValueTenWhenHasOneItemWithPrice() {

		Product product = new Product();
		product.setPrice(BigDecimal.TEN);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(product);
		orderItem.setAmount(BigDecimal.ONE);
		
		List<OrderItem> items = new ArrayList<>();
		items.add(orderItem);

		Order order = new Order();
		order.setItems(items);
		BigDecimal totalValue = order.getTotalValue();

		logger.info("shouldTotalValueTenWhenHasOneItemWithPrice -> expected: 0 and was: {}", totalValue);
		assertEquals(BigDecimal.TEN, totalValue);
	}
	
	@Test
	public void shouldTotalValueOneHundredOneWhenHasTwoItems() {

		Product product1 = new Product();
		product1.setPrice(BigDecimal.TEN);
		
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setProduct(product1);
		orderItem1.setAmount(BigDecimal.TEN);
		
		Product product2 = new Product();
		product2.setPrice(BigDecimal.ONE);
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProduct(product2);
		orderItem2.setAmount(BigDecimal.ONE);
		
		List<OrderItem> items = new ArrayList<>();
		items.add(orderItem1);
		items.add(orderItem2);
		
		Order order = new Order();
		order.setItems(items);
		BigDecimal totalValue = order.getTotalValue();

		logger.info("shouldTotalValueOneHundredOneWhenHasTwoItems -> expected: 101 and was: {}", totalValue);
		assertEquals(new BigDecimal("101"), totalValue);
	}
}
