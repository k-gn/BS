package org.example.chap1;

public class Bag {

	private Invitation invitation;
	private Ticket ticket;
	private Long amount;

	public Bag(
		Invitation invitation,
		Long amount
	) {
		this.invitation = invitation;
		this.amount = amount;
	}

	public Bag(Long amount) {
		this.amount = amount;
	}

	public boolean hasInvitation() {
		return this.invitation != null;
	}

	public boolean hasTicket() {
		return this.ticket != null;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}
}
