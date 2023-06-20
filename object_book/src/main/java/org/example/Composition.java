package org.example;

/*
	- 상속과 함성은 널리 사용되는 코드 재사용 기법이다.
	- 상속은 부모 클래스와 자식 클래스 사이의 의존성이 컴파일타임에 해결
	- 합성은 부모 클래스와 자식 클래스 사이의 의존성이 런타임에 해결
	- 상속 : is-a / 합성 : has-a
	- 상속과 합성은 코드 재사용이란 목적을 제외하면 모든 면에서 차이가 있다.

	- 상속
		- 자식 클래스의 정의에 부모 클래스 이름을 덧붙여서 부모 클래스의 코드를 재사용
		- 자식 클래스는 부모 클래스의 정의 대부분을 물려받는다.
		- 부모 클래스와 다른 부분만 추가하거나 재정의하여 확장한다.
		- 상속을 제대로 활용하려면 부모 클래스 내부 구현에 대해 상세히 알아야 한다.
			- 부모 클래스 내부가 자식 클래스에 공개된다.
				- 캡슐화를 위배한다.
			- 자식과 부모클래스 사이에 결합도가 높아진다. (변경에 대한 영향이 높다)
			- 상속은 코드를 재사용할 수 있는 쉽고 간단한 방법이지만 우아한 방법은 아니다.
		- 상속 관계는 클래스 사이의 정적인 관계
		- 부모 클래스의 구현된 코드 자체를 재사용

		- 상속으로 발생할 수 있는 문제점
			- 불필요한 인터페이스 상속 문제
				- 부적합한 부모클래스의 오퍼레이션 상속으로 인한 불안정한 자식클래스 (ex. Stack, Properties class)
			- 메서드 오버라이딩 오작용 문제
				- 부모 클래스 메서드를 오버라이딩할 때 자식 클래스가 부모 클래스 메서드 호출 방법에 영향을 받음 (ex. HashSet add, addAll)
			- 부모 클래스와 자식 클래스 동시 수정 문제
				- 하나의 기능을 추가하거나 수정하기 위해 많은 수의 클래스를 추가하거나 수정해야 한다.
			- 단일 상속만 지원하는 언어에서 상속은 오히려 중복 코드의 양이 늘어날 수도 있다.
			- 요구사항에 따른 클래스 폭발이 발생할 수 있다.
				- 합성을 사용하면 하나의 요구사항이 변경될 때 단 하나만 변경되도록 설계할 수도 있다.

	- 합성
		- 구현에 의존하지 않는다.
		- 객체의 구현이 아닌 퍼블릭 인터페이스에 의존
		- 객체의 내부 구현이 변경되어도 영향을 최소화할 수 있어 변경에 더 안정적이다.
		- 합성 관계는 객체 사이의 동적인 관계
			- 실행 시점에 동적으로 변경할 수 있다. -> 변경하기 쉽고 유연하다.
		- 객체의 퍼블릭 인터페이스를 재사용
			- 구현에 대한 의존 -> 인터페이스에 대한 의존
			- 클래스 사이의 높은 결합도 -> 객체 사이의 낮은 결합도
		- 런타임에 객체를 조합하고 사용하는 방식

	- 대부분의 경우 구현이 아닌 인터페이스에 대한 결합이 더 좋다.
	- 합성이 상속보다 더 좋은 방법이다.
	- 상속은 타입 계층을 구조화하기 위해 사용해야 한다. (다형성)
		- 부모클래스와 자식클래스의 관계를 정의

	- 언제 상속을 해야하나? (어떤 조건을 만족해야 타입 계층을 위해 사용하는 것일까?)
		1. 상속관계 is-a 관계를 모델링 하는지?
			- 단, 행동을 고려하지 않은 단순 is-a 관계는 연결하지 말자.
		2. 클라이언트 입장에서 부모 클래스 타입으로 자식 클래스를 사용해도 무방한지? (행동 호환성)
			- 두 타입이 동알하게 행동할 것이라고 기대
		- 2번이 더 중요하다.
		- 중요한 것은 클라이언트의 기대에 따른 계층 분리
			ex1. 		 Bird
				FlyingBird	Penguin

			ex2.  Flyer, Walker
				  Bird,  Penguin

		- 행동 호환성과 대체 가능성이 가장 따라야할 지침
			- 클라이언트 관점으로 볼 것을 강조 (클라이언트와의 협력관계)
			- 리스코프 치환 원칙
				- 개방 폐쇄 원칙을 지키기 위한 전제 조건
				- 위반 ex. Rectangle, Square / Vector, Stack
				- 포함되선 안되는 퍼블릭 인터페이스 노출

	# 다형성
		- 여러 타입을 대상으로 동작할 수 있는 코드를 작성하는 방법
		- 실제로 메시지를 수신하는 객체의 타입에 따라 실행되는 동작이 다르다.
			- 업캐스팅과 동적 바인딩
			- 메서드 오버로딩, 오버라이딩
			- this, super
		- 언어마다 다르다.

	- 위임
		- 자신이 수신한 메시지를 다른 객체에게 동일하게 전달해서 처리를 요청하는 것
		- 자신이 정의하지 않거나 처리할 수 없는 속성 또는 메서드 탐색 과정을 다른 객체로 이동시킨다.

	- 타입
		- 적용 가능한 오퍼레이션의 종류와 의미를 정의함으로써 코드의 의미를 명확하게 전달
		- 개발자의 실수를 방지
		- 개념 관점에서 공통의 특징을 공유하는 대상들의 분류
		- 프로그래밍 언어 관점에서 동일한 오퍼레이션을 적용할 수 있는 인스턴스들의 집합
		- 객체의 퍼블릭 인터페이스가 타입을 결정한다.
			- 동일한 퍼블릭 인터페이스를 공유한다면 동일한 타입으로 분류
			- 항상 객체가 외부에 제공하는 행동에 초점을 맞춘다. (내부 속성에 초점 X)
		- 타입은 다른 타입에 포함될 수 있다.
			- 동일한 인스턴스가 하나 이상의 타입으로 분류되는 것도 가능
			- 포함되는 타입은 좀 더 특수하고 구체적이다.
			- 두 타입간의 더 일반적인 타입을 슈퍼타입, 더 특수한 타입을 서브타입 이라고 부른다.
		- 슈퍼타입
			- 집합이 다른 집합의 모든 멤버를 포함한다.
			- 타입 정의가 좀 더 일반적이다.
				- 더 일반적인 퍼블릭 인터페이스 (넓은 정의)
		- 서브타입
			- 집합에 포함되는 인스턴스들이 더 큰 집합에 포함된다.
			- 타입 정의가 좀 더 구체적이다.
				- 더 특수한 퍼블릭 인터페이스 (좁은 정의)
		- 서브타입 인스턴스는 슈퍼타입으로 간주될 수 있다.
		
	- 인터페이스 분리 원칙
		- 클라이언트의 기대에 따라 인터페이스를 분리함으로써 변경에 의한 영향을 제어하는 설계 원칙
		- 비대한 인터페이스 단점을 해결

	- 서브 클래싱
		- 코드를 재사용할 목적으로 상속 사용
		- 구현 상속 또는 클래스 상속
	
	- 서브 타이핑
		- 타입 계층 구성을 위한 상속 사용
		- 인터페이스 상속

	- 서브타입에 더 강력한 사전조건을 정의할 수 없다.
	- 서브타임에 슈퍼타입과 같거나 더 약한 사전 조건을 정의할 수 있다.
	- 서브타입에 더 강력한 사후조건을 정의할 수 있다.
	- 서브타임에 슈퍼타입과 같거나 더 약한 사후 조건을 정의할 수 없다.
	- 즉, 서브타입에 추가되거나 사라지는 조건들과 관계없이
	  기본적으로 현재 협력하고 있는 객체의 사전조건과 사후조건은 기본적으로 만족해야 한다.

	  
 */
public class Composition {
}
