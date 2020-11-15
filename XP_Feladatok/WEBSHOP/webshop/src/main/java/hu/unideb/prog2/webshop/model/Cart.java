package hu.unideb.prog2.webshop.model;

import java.util.LinkedList;
import java.util.List;

public class Cart {

	List<Integer> cartList;

	public Cart() {
		super();
		this.cartList = new LinkedList<>();
	}

	public void add(Integer productType, Integer quantity) {

		for (int i = 0; i < quantity; i++) {
			cartList.add(productType);
		}
	}

	public List<Integer> list() {
		// TODO Auto-generated method stub
		return cartList;
	}
}
