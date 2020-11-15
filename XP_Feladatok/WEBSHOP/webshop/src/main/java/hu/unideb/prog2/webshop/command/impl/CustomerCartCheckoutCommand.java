package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductDAO;
import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.Cart;


public class CustomerCartCheckoutCommand extends AbstractCommand {

	private Cart cart;
	private ProductDAO productDAO;
	private ProductTypeDAO productTypeDAO;
	Integer  total;
		
	
	
	public CustomerCartCheckoutCommand(Cart cart, ProductDAO productDAO ,ProductTypeDAO productTypeDAO) {
		super("customer", "cart", "checkout");
		// TODO Auto-generated constructor stub
		this.cart=cart;
		this.productDAO = productDAO;
		this.productTypeDAO=productTypeDAO;
		this.total=0;
	}

	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		for (Integer typeId : cart.list()) {
			total+= productTypeDAO.getPrice(typeId);
			try {
				productDAO.buying(typeId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return "CustomerCartCheckoutCommand is called finale Cost:" + total;
	}

}
