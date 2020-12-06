package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductDAO;
import hu.unideb.prog2.webshop.model.Product;

public class AdminProductAddCommand extends AbstractCommand {
	private ProductDAO productDAO;

	public AdminProductAddCommand(ProductDAO productDAO) {
		super("admin", "product", "add");
		// TODO Auto-generated constructor stub
		this.productDAO = productDAO;
	}

	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		productDAO.create(new Product(Integer.parseInt(commandString[3]), Integer.parseInt(commandString[4])));
		return getClass().toString() + "is called";
	}

}
