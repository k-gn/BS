package org.example.movie;

import java.math.BigDecimal;

/*
    - 금액 구현을 위해 Long 타입을 사용할 수 있지만, Money 처럼 금액 관련 의미를 전달할 수 없다.
    - 또한 금액 관련 로직이 서로 다른 곳에 중복되어 있을 것이다.
    - 객체지향은 이렇게 Money 처럼 도메인의 의미를 풍부하게 표현할 수 있다.

    => 의미를 좀 더 명시적이고 분명하게 표현할 수 있다면 객체를 사용해서 해당 개념을 구현하자
    => 전체적인 설계의 명확성과 유연성을 높여준다.
 */
public class Money {

    public static final Money ZERO = Money.wons(0);
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money money) {
        return new Money(this.amount.add(money.amount));
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }
}
