package org.example.movie;

import java.time.LocalDateTime;

public class Screening {

    /*
        - 클래스의 경계를 구분짓는 것은 중요하다.
            - 내부와 외부로 구분되어, 어떤 부분을 외부에 공개하고 어떤 부분을 감출지 결정하는 것
            - 캡슐화
            - 경계의 명확성은 객체의 자율성을 보장한다.
                - 객체 스스로 판단하고 행동하는 존재
                - 외부 간섭을 최소화

            - ## 인터페이스와 구현의 분리 ##
            - 클래스 작성자는 클라이언트에게 필요한 부분만 공개하고 나머지는 숨긴다.
                - 클라이언트에 의한 영향을 걱정하지 않고 내부 구현을 변경할 수 있다. => 구현 은닉
                - 클래스 작성자는 인터페이스를 바꾸지 않는 이상 외부에 영향일 미칠 걱정을 하지 않고 내부 구현을 수정할 수 있다.
                - 클라이언트는 내부 구현을 몰라도 인터페이스만으로 사용할 수 있어서 머리에 담아둘 지식의 양을 줄일 수 있다. => 복잡성 감소
            - 객체 사이의 의존성을 적절히 관리함으로 변경에 대한 파급효과를 제어할 수 있다.
     */
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    /*
        - 어떤 기능을 구현하기 위해 객체들 사이에 이뤄지는 상호작용을 "협력" 이라고 한다.
            - 먼저 협력의 관점에서 어떤 객체가 필요한지 결정한다.
     */
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
