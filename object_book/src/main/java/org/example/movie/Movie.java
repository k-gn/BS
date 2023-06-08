package org.example.movie;

import java.time.Duration;

/*
    1. 클래스가 아닌 어떤 객체가 필요한지 고민한다.
    2. 객체가 어떤 상태와 행동을 가지는지 고민한다.
    3. 객체를 고립적인 존재가 아닌 협력적인 존재로 인지하고, 유연하고 확장 가능하게 만든다.
    4. 객체를 타입으로 분류하고, 클래스를 구현한다.
    5. 도메인을 구성한 개념이 도움이 된다.
    6. 객체지향이 강력한 이유는 요구사항 분석 초기 단계부터 마지막까지 객체라는 동일한 추상화 기법을 사용할 수 있기 때문이다.
 */
public class Movie {

    private String title;
    private Duration runningTime;

    /*
        - 할인정책을 판단하는 코드가 없고 단지 메시지를 전송할 뿐이다.
        - 상속, 다형성, 추상화 원리가 숨겨져 있다.
        - 코드의 의존성과 실행 시점의 의존성을 서로 다를 수 있다.
            - 트레이드 오프가 존재한다.
                - 코드의 의존성과 실행 시점의 의존성이 다르면 다를 수록 코드는 더 유연해지고 확장 가능해진다.
                - 코드의 의존성과 실행 시점의 의존성이 다르면 다를 수록 어떤 객체를 의존하는지 찾아야 해서 이해하고 디버깅하기 어려워진다.
                - 즉, 유연성과 가독성 사이에서 고민해야 한다.
        - 누구의 어떤 메서드가 동작할 것인지는 실행 시점에 실제 클래스가 무엇인지에 따라 달라진다. => 다형성
            - 컴파일 시간 의존성과 실행 시간 의존성이 다를 수 있다.
            - 동일한 메시지를 수신했을 때 객체 타입에 따라 다르게 동작할 수 있다. (지연 바인딩 or 동적 바인딩)
                - 다형적인 협력에 참여하는 객체들은 모두 동일한 인터페이스를 가져야 한다.
                - 인터페이스 상속을 통해 동일한 인터페이스를 물려 받아 인터페이스를 통일할 수 있다.
                    - 즉, 동일한 인터페이스를 공유하는 클래스들을 하나의 타입 계층으로 묶을 수 있다.
                    - 구현 상속과 인터페이스 상속으로 구분된다.
                        - 구현 상속 : 코드 재사용을 목적 (변경애 취약한 코드를 낳을 수 있다.)
                        - 인터페이스 상속 : 다형적인 협력을 위해 인터페이스 공유를 목적

        - 추상화
            - 요구사항의 정책을 높은 수준에서 서술 가능하다.
            - 설계가 좀 더 유연해진다.
                - 기존 구조를 수정하지 않고 새로운 기능을 쉽게 추가/확장할 수 있다.
                - ex. NoneDiscountPolicy
            - 세부적인 내용을 무시한 채 상위 정책을 쉽고 간단히 표현할 수 있다. (필요에 따라 표현의 수준을 조정)
                - 복잡성을 낮춘다.
     */
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
