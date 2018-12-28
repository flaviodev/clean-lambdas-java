package com.github.flaviodev.model;

import java.math.BigDecimal;
import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Product {
	private @Getter @Setter String description;
	private @Setter BigDecimal price;

	public Optional<BigDecimal> getPriceOpt() {
		return Optional.ofNullable(price);
	}
}
