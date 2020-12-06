package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductDAO;

public class AdminProductRemoveCommand extends AbstractCommand {

	private ProductDAO productDAO;

	public AdminProductRemoveCommand(ProductDAO productDAO) {
		super("admin", "product", "remove");

		this.productDAO = productDAO;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		productDAO.remove(Integer.parseInt(commandString[3]));
		return "AdminProductRemove is called";
	}

}
