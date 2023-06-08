package org.example.movie;

/*
    - 구현은 공유할 필요 없고, 순수히 인터페이스만 공유
 */
public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
