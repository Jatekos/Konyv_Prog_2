package hu.unideb.prog2.webshop.command.impl;


import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;

public class AdminProductTypeRemoveCommand extends AbstractCommand  {

	private ProductTypeDAO productTypeDAO;

	public AdminProductTypeRemoveCommand(ProductTypeDAO productTypeDAO) {
		super("admin", "product_type", "remove");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		
		productTypeDAO.remove(Integer.parseInt(commandString[3]));
		
		return "AdminProductTypeRemoveCommand is called ";
	}

}
