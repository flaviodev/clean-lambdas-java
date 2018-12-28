package com.github.flaviodev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.flaviodev.model.Costumer;
import com.github.flaviodev.model.GoldCard;
import com.github.flaviodev.model.Profile;

public class OptionalVsNPETest {

	private Logger logger = LoggerFactory.getLogger(OptionalVsNPETest.class);

	@Test(expected = NullPointerException.class)
	public void shouldThrowNPEOnGetGoldeCardFromProfile() {

		logger.info("shouldThrowNPEOnGetGoldeCardFromProfile -> expected: NullPointerException");

		Costumer costumer = new Costumer();
		costumer.getProfile().getGoldCardOpt();

		fail("it was expected the throw of nullpointerexception");
	}

	@Test
	public void shouldDiscountZeroWhenProfileIsNull() {

		Costumer costumer = new Costumer();
		BigDecimal discount = costumer.getDiscount();

		logger.info("shouldDiscountZeroWhenProfileIsNull -> expected: 0 and was: {}", discount);
		assertEquals(BigDecimal.ZERO, discount);
	}

	@Test
	public void shouldDiscountZeroWhenGoldCardIsNull() {

		Profile profile = new Profile();
		profile.setName("Costumer name");

		Costumer costumer = new Costumer();
		costumer.setProfile(profile);

		BigDecimal discount = costumer.getDiscount();

		logger.info("shouldDiscountZeroWhenGoldCardIsNull -> expected: 0 and was: {}", discount);
		assertEquals(BigDecimal.ZERO, discount);
	}

	@Test
	public void shouldDiscountZeroWhenDiscountIsNull() {

		GoldCard goldCard = new GoldCard();
		goldCard.setNumber("0000 0000 0000 0000");

		Profile profile = new Profile();
		profile.setName("Costumer name");
		profile.setGoldCard(goldCard);

		Costumer costumer = new Costumer();
		costumer.setProfile(profile);

		BigDecimal discount = costumer.getDiscount();

		logger.info("shouldDiscountZeroWhenDiscountIsNull -> expected: 0 and was: {}", discount);
		assertEquals(BigDecimal.ZERO, discount);
	}

	@Test
	public void shouldDiscountTenFromGoldCard() {

		GoldCard goldCard = new GoldCard();
		goldCard.setNumber("0000 0000 0000 0000");
		goldCard.setDiscount(BigDecimal.TEN);

		Profile profile = new Profile();
		profile.setName("Costumer name");
		profile.setGoldCard(goldCard);

		Costumer costumer = new Costumer();
		costumer.setProfile(profile);

		BigDecimal discount = costumer.getDiscount();

		logger.info("shouldDiscountTenFromGoldCard -> expected: 10 and was: {}", discount);
		assertEquals(BigDecimal.TEN, discount);
	}
}
