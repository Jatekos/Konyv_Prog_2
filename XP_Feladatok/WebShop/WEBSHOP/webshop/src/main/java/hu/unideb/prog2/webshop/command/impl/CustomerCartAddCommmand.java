package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.model.Cart;

public class CustomerCartAddCommmand extends AbstractCommand {

	private Cart cart = new Cart();

	public CustomerCartAddCommmand(Cart cart) {
		super("customer", "cart", "add");
		this.cart = cart;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		cart.add(Integer.parseInt(commandString[3]), Integer.parseInt(commandString[4]));
		return "CustomerCartAddCommmand is called";
	}

}
