package org.example.movie;

// 공통의 구현이 필요없고 단지 책임 목록만 정의 -> 인터페이스
public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
