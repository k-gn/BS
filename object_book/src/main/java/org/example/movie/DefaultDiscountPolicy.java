package org.example.movie;

import java.util.ArrayList;
import java.util.List;

/*
    - 중복 코드를 제거하기 위한 추상
    - 차이에 의한 프로그래밍
        - 부모 클래스와 다른 부분만을 추가해 새로운 클래스를 쉽고 빠르게 만드는 방법
        - 자식 클래스는 부모 클래스가 수신할 수 있는 모든 메시지를 수신할 수 있어서 부모 클래스와 동일한 타입으로 간주할 수 있다.
            => 업캐스팅

    - 상속은 객체지향에서 코드 재사용을 위해 널리 사용되는 기법이다.
    - 하지만 설계에 안좋은 영향을 끼친다.
        - 캡슐화를 위반한다.
            - 상속을 위해선 부모 클래스 구조를 잘 알고 있어야 한다.
            - 즉, 부모 클래스의 구현이 자식 클래스에게 노출된다.
            - 캡슐화 약화는 자식 클래스와 부모 클래스의 강결합을 유도한다.
        - 설계를 유연하지 못하게 한다.
            - 부모 클래스를 변경할 때 자식 클래스도 함께 변경될 확률이 높다.
            - 과도하게 사용하면 코드 변경이 어려워진다.
            - 부모 클래스와 자식 클래스 관계를 컴파일 시점에 결정하기 때문에 실행 시점에 변경이 불가능하다.

    - 합성을 사용하면 상속의 문제점을 모두 해결할 수 있다.
    - 상속을 사용하지 말라는 것이 아니다.
        - 다형성을 위해 인터페이스를 재사용하는 경우 상속과 합성을 적절히 조합해서 사용한다.
        - 상속 사용 시 고려할 사항
            - 하위 클래스가 상위 클래스의 진짜 하위 타입인 상황인가? (Dog is an Animal)
            - 상속으로 인해 내부 구현을 불필요하게 노출하고 있는 것은 아닌가?
            - 확장하려는 클래스에 결함이 있다면 결함이 내 클래스까지 전파돼도 괜찮은가?

    - 공유하는 상태와 행동의 기본 구현이 존재 -> 추상 클래스
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(List<DiscountCondition> conditions) {
        this.conditions = conditions;
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
