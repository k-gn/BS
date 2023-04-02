package org.example.chap1;

public class Audience {

	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	public Long buy(Ticket ticket) {
		return this.bag.hold(ticket);
	}
}
