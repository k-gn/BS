package org.example.movie;


/*
    - 일관성을 지키기 위한 할인 정책
        - 할인 금액이 0원이라는 사실을 조건문으로 사용하는 것보다 이렇게 클래스로 일관성을 유지
        - 적절한 책임 분배
        - 이 클래스를 위해 인터페이스를 추가하는 것이 과할까? 하는 트레이드 오프가 있을 수 있다.
 */
public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
