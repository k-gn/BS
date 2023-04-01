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
}
