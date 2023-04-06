package org.example.ticket;

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

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}

	public Long hold(Ticket ticket) {
		if (this.hasInvitation()) {
			this.ticket = ticket;
			return 0L;
		} else {
			this.minusAmount(ticket.getFee());
			this.ticket = ticket;
			return ticket.getFee();
		}
	}
}
