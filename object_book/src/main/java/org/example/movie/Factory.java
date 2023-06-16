package org.example.movie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import com.sun.tools.javac.util.List;

public class Factory {

	public Movie createAvatarMovie() {
		AmountDiscountPolicy amountDiscountPolicy = new AmountDiscountPolicy(
			List.of(
				new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0))
			),
			Money.wons(1000)
		);

		return new Movie(
			"아바타",
			Duration.ofMinutes(120),
			amountDiscountPolicy,
			Money.wons(10000)
		);
	}
}
