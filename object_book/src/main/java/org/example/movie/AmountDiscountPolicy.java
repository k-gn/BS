package org.example.movie;

import java.util.List;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountMoney;

    public AmountDiscountPolicy(List<DiscountCondition> conditions, Money discountMoney) {
        super(conditions);
        this.discountMoney = discountMoney;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountMoney;
    }
}
