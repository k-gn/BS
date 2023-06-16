package org.example.movie;

import java.util.List;

public class OverlappedDiscountPolicy implements DiscountPolicy {

	private List<DiscountPolicy> discountPolicies;

	public OverlappedDiscountPolicy(List<DiscountPolicy> discountPolicies) {
		this.discountPolicies = discountPolicies;
	}

	@Override
	public Money calculateDiscountAmount(Screening screening) {
		Money result = Money.ZERO;
		for (DiscountPolicy each : discountPolicies) {
			result = result.plus(each.calculateDiscountAmount(screening));
		}
		return result;
	}
}
