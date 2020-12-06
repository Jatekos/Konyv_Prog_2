package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductDAO;

public class AdminProductListCommand extends AbstractCommand {

	private ProductDAO productDAO;

	public AdminProductListCommand(ProductDAO productDAO) {
		super("admin", "product", "list");
		// TODO Auto-generated constructor stub
		this.productDAO = productDAO;
	}

	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		
		return productDAO.list().toString();
	}

}
