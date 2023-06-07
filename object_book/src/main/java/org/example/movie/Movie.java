package org.example.movie;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private DiscountPolicy discountPolicy;
    private Money fee;

    private MovieType movieType;

    private Money discountAmount;

    private double discountPercent;

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

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}