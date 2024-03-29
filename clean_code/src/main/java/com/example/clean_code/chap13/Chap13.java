package com.example.clean_code.chap13;

/*
	# 동시성

	- 동시성과 깔끔한 코드는 양립하기 어렵다.
	- 동시성은 결합을 없애는 전략이다.
		- 즉, 무엇과 언제를 분리하는 전략이다.
		- 스레드가 하나인 프로그램은 무엇과 언제가 밀접하다.
	- 동시성은 불가피하다. 하지만 어렵다.
	- 동시성에 대한 미신과 오해
		- 동시성은 항상 성능을 높여준다?
			- 동시선은 때로 성능을 높여준다.
			- 여러 프로세서가 동시에 처리할 계산이 많은 경우 성능이 높아진다.
		- 동시성을 구현해도 설계는 변하지 않는다?
			- 단일 스레드와 다중 스레드 시스템은 설계가 판이하게 다르다.
			- 무엇과 언제를 분리하면 구조는 크게 달라진다.
		- 동시성은 간단하고 이해할 필요가 없다?
			- 어떻게 동작하는지 어떻게 동시 수정 되는지, 데드락 등 다양한 이해를 요구한다.
			- 동시성은 다소 부하를 유발한다.
			- 동시성은 복잡하다.
			- 동시성 버그는 재현하기 어렵다.
			- 동시성을 구현하려면 흔히 근본적인 설계 전략을 재고해야한다

	- 동시성 방어 원칙
		- 단일 책임 원칙
			- 동시성은 복잡성 하나만으로도 따로 분리할 이유가 충분하다.
			- 동시성 코드를 다른 코드와 분리하자.
				- 동시성 코드는 독자적인 개발, 변경, 조율 주기가 있다.
				- 잘못 구현된 동시성 코드는 별의별 방식으로 실패한다.
		- 자료 범위를 제한하라.
			- 공유 객체를 사용하는 코드 내 임계영역을 synchronized 키워드로 보호 권장
			- 임계 영역의 수를 줄이는 기술이 중요하다.
			- 자료를 캡슐화라고 공유 자료를 최대한 줄이자.
		- 자료 사본을 사용하라
		- 스레드는 가능한 독립적으로 구현하라

	- 라이브러리 이해
		- 스레드 환경에 안전한 컬렉션 사용
 */
public class Chap13 {
}
