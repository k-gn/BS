package com.example.clean_code.chap2_naming;

/*
	# 의미있는 이름

	1. 의도를 분명히 밝혀라
		- 코드의 함축성 (정보 제공)
		- 의도가 드러난 이름을 사용하면 코드 이해와 변경이 쉬워진다.

	2. 그릇된 정보를 피하라
		- 일관성이 떨어지는 정보는 그릇된 정보다.
		- accountList -> accounts
		- 서로 흡사한 이름을 사용하지 않도록 주의

	3. 의미있게 구분하라
		- a1, a2 -> source, destination
		- 불용어는 중복이다.
			- NameString -> Name
			- CustomerObject -> Customer
			- getAccountInfo() -> getAccount()
		- 명확한 관례가 있다면 괜찮다.

	4. 발음하기 쉬운 이름을 사용하라
		- 발음하기 어려운 이름은 토론하기도 어렵다.
		- 지적인 대화가 가능해진다.
		- genymdhms -> generationTimestamp

	5. 검색하기 쉬운 이름을 사용하라
		- s -> sum
		- 이름을 의미있게 지으면 길어진다 -> 검색하기 쉬워진다.
		- 이름 길이는 범위 크기에 비례해야 한다.
			- 여러곳에서 사용해야 한다면 검색하기 쉬운 이름이 바람직하다.

	6. 인코딩을 피하라.
		- 헝가리식 표기법 x
		- 멤벼변수 접두어 사용 x
		- 인터페이스와 구현클래스 관계에서 구현클래스 인코딩까진 허용한다.
			- ShapeFactory 와 ShapeFactoryImpl

	7. 자신의 기억력을 자랑하지 마라
		- 문자 하나만 사용하는 변수이름 x (루프 제외)
		- 코드를 읽으며ㅑㄴ서 자신이 아는 이름으로 변환해야 한다면 바람직하지 못한 변수이름이다.

	8. 클래스 이름
		- 명사, 명사구

	9. 메서드 이름
		- 동사, 동사구
		- 생성자 중복 정의 시 정적 팩토리 메서드 사용

`	10. 기발한 이름은 피하라
		- 재미난 이름보단 명료한 이름을 선택하라

	11. 한 개념에 한 단어를 사용하라
		- 일관성 있는 어휘 사용
		- 동일한 코드 기반에 controller, manager, driver 등을 섞어쓰지 말 것
			- 동일한 코든데 어떤 애는 ProtocolController, 어떤 애는 UrlManager

	12. 말장난을 하지 마라
		- 한 단어를 두가지 목적으로 사용하지 마라
			- 맥락이 같아야 한다.

	13. 해법 영역에서 가져온 이름을 사용하라
		- 전산용어, 알고리즘, 디자인 패턴, 수학용어 등을 사용해도 좋다.
		- 기술 개념에는 기술 이름이 가장 적합하다.

	14. 문제 영역에서 가져온 이름을 사용하라
		- 적절한 프로그래밍 용어가 없다면 문제 영역에서 이름을 가져온다.
		- 분야 전문가에게 물어 파악할 수 있다.

	15. 의미있는 맥락을 추가하라
		- 쿨래스, 함수, 이름 공간에 넣어 맥락을 부여한다.
		- ex. GuessStatisticsMessage

	16. 불필요한 맥락을 없애라
		- 일반적으로 짧은 이름보단 긴 이름이 좋지만, 의미가 분명해야 한다.
		- accountAddress, customerAddress 같은 이름은 인스턴스로는 좋지만, 클래스 이름으론 별로다.
			- 그냥 Address 가 적합하다.
			- 구분을 해줘야 한다면 해도 되긴하다. (PostalAddress, Mac, Uri ...)
 */
public class Naming {

	/*
		15 - 맥락이 불분명한 함수
			- 함수 자체가 일단 길고, 함수를 끝까지 읽어야 number, verb, pluralModifier 변수가 통계 추측 메시지에 사용된다는 사실이 드러난다.
			- 함수를 잘개 쪼개기 위한 클래스를 만들면 맥락을 분명하게 해줄 수 있다.
	 */
	private void printGuessStatistics(
		char candidate,
		int count
	) {
		String number;
		String verb;
		String pluralModifier;

		if (count == 0) {
			number = "no";
			verb = "are";
			pluralModifier = "s";
		} else {
			number = Integer.toString(count);
			verb = "are";
			pluralModifier = "s";
		}

		String guessMessage = String.format(
			"There %s %s %s%s", verb, number, candidate, pluralModifier
		);
		System.out.println(guessMessage);
	}
}

class GuessStatisticsMessage {
	private String number;
	private String verb;
	private String pluralModifier;

	public String make(
		char candidate,
		int count
	) {
		createPluralDependentMessageParts(count);
		return String.format(
			"There %s %s %s%s", verb, number, candidate, pluralModifier
		);
	}

	private void createPluralDependentMessageParts(int count) {
		if (count == 0) {
			thereAreNoLetters();
		} else {
			thereAreManyLetters(count);
		}
	}

	private void thereAreManyLetters(int count) {
		number = Integer.toString(count);
		verb = "are";
		pluralModifier = "s";
	}

	private void thereAreNoLetters() {
		number = "no";
		verb = "are";
		pluralModifier = "s";
	}
}
