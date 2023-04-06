package org.example.movie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
