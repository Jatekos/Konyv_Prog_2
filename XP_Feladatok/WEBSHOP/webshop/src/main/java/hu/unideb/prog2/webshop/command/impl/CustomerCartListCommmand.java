package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.model.Cart;

public class CustomerCartListCommmand extends AbstractCommand {

	private Cart cart = new Cart();

	public CustomerCartListCommmand(Cart cart) {
		super("customer", "cart", "list");
		this.cart = cart;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		
		return cart.list().toString();
	}

}
