package com.github.flaviodev.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Order {
	private @Getter @Setter String id;
	private @Getter @Setter boolean notDelivered;

	private @Setter List<OrderItem> items;

	public Optional<List<OrderItem>> getItemsOpt() {
		return Optional.ofNullable(items);
	}

	public BigDecimal getTotalValue() {
		return new BigDecimal(getItemsOpt().orElse(Collections.emptyList()).stream()
				.mapToDouble(item -> item.getItemValue().doubleValue()).sum());
	}

	public BigDecimal getTotalItemsAmount() {
		return new BigDecimal(getItemsOpt().orElse(Collections.emptyList()).stream()
				.mapToDouble(item -> item.getAmountOpt().orElse(BigDecimal.ZERO).doubleValue()).sum());
	}
}
