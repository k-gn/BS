package org.example.coffee;

public class Coffee {

	private final String name;

	private final int price;

	public Coffee(MenuItem menuItem) {
		this.name = menuItem.getName();
		this.price = menuItem.cost();
	}
}
