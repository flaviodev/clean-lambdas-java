package com.github.flaviodev.model;

import java.math.BigDecimal;
import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Costumer {

	private @Getter @Setter Profile profile;

	public Optional<Profile> getProfileOpt() {
		return Optional.ofNullable(profile);
	}

	public BigDecimal getDiscount() {
			
		return getProfileOpt()
				.flatMap(Profile::getGoldCardOpt) // return Optional<GoldCard> instead Optional<Optional<GoldCard>>
				.map(GoldCard::getDiscount)
				.orElse(BigDecimal.ZERO);
	}
}