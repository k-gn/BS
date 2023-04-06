package org.example.ticket;

public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	/*
		1. 이해하기 어려움 (의도를 파악하기 힘듬)
		2. 변경에 취약함 (결합도가 높은 메소드)

		* Theater 는 audience 의 Bag / ticketSeller 의 ticketOffice 에 대한 정보를 알 필요가 사실상 없다!
		=> 객체를 자율적인 존재로 만들어 준다. (캡슐화)
	 */
	public void enter(Audience audience) {
		ticketSeller.sellTo(audience);
	}
}
