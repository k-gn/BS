package org.example.chap2;

import java.util.List;

public class AmountDiscountPolicy extends DiscountPolicy {

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
