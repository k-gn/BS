package org.example.chap2;

import javax.management.Query;
import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private DiscountPolicy discountPolicy;
    private Money fee;

    public Movie(String title, Duration runningTime, DiscountPolicy discountPolicy, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.discountPolicy = discountPolicy;
        this.fee = fee;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
