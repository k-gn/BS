package org.example.coffee;

public class Customer {

	public Coffee order(
		String menuName,
		Menu menu,
		Barista barista
	) {
		MenuItem menuItem = menu.choose(menuName);
		return barista.makeCoffee(menuItem);
	}
}
