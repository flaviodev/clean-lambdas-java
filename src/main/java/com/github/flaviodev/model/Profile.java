package com.github.flaviodev.model;

import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Profile {
	private @Getter @Setter String name;	
	
	private @Setter GoldCard goldCard;
	
	public Optional<GoldCard> getGoldCardOpt() {
		return Optional.ofNullable(goldCard);
	}
}
