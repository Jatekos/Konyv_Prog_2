package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.ProductType;

public class AdminProductTypeAddCommand extends AbstractCommand {

	private ProductTypeDAO productTypeDAO;
	
	public AdminProductTypeAddCommand(ProductTypeDAO productTypeDAO) {
		super("admin", "product_type", "add");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String[] commandString) {
		
		if(commandString.length!=7) {
			throw new IllegalArgumentException("Invalid command" );
		}
		productTypeDAO.create(new ProductType(commandString[3], commandString[4], commandString[5], Integer.parseInt((commandString[6]))));
		
		
		return "AdminProductTypeAddCommand is called";
	}

}
