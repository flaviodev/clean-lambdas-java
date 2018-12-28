package com.github.flaviodev.model;

import java.math.BigDecimal;
import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Setter;

@EqualsAndHashCode
public class OrderItem {
	private @Setter Product product;
	private @Setter BigDecimal amount;

	public Optional<Product> getProductOpt() {
		return Optional.ofNullable(product);
	}

	public Optional<BigDecimal> getAmountOpt() {
		return Optional.ofNullable(amount);
	}

	public BigDecimal getProductPrice() {
		return getProductOpt().flatMap(Product::getPriceOpt).orElse(BigDecimal.ZERO);
	}

	public BigDecimal getItemValue() {
		return getProductPrice().multiply(getAmountOpt().orElse(BigDecimal.ZERO));
	}
}
