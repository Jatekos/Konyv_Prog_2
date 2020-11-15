package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;

public class CustomerProductTypeListCommand extends AbstractCommand {
	private ProductTypeDAO productTypeDAO;

	public CustomerProductTypeListCommand(ProductTypeDAO productTypeDAO) {
		super("customer", "product_type", "list");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String[] commandString) {
		return productTypeDAO.list().toString();
	}

}
