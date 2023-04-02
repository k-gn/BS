package org.example.chap1;

import java.util.List;

public class TicketOffice {

	private List<Ticket> tickets;
	private Long amount;

	public TicketOffice(
		List<Ticket> tickets,
		Long amount
	) {
		this.tickets = tickets;
		this.amount = amount;
	}

	public Ticket getTicket() {
		return tickets.remove(0);
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}

	/*
		# 트레이드오프 발생 지점
		- ticketOffice 의 자율성은 올라갔지만, audience 와의 의존성이 발생한 부분
		- ticketSeller 가 ticketOffice 를 다뤄 의존성을 낮출지, 아니면 ticketOffice 의 자율성을 높일지
	 */
	public void sellTicketTo(Audience audience) {
		this.plusAmount(audience.buy(getTicket()));
	}
}
