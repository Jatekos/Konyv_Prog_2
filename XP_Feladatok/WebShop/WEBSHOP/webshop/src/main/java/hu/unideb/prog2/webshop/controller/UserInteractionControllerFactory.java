package hu.unideb.prog2.webshop.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.prog2.webshop.command.impl.AbstractCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductAddCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductImportCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductListCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductRemoveCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeAddCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeImportCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeListCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeRemoveCommand;
import hu.unideb.prog2.webshop.command.impl.CustomerCartAddCommmand;
import hu.unideb.prog2.webshop.command.impl.CustomerCartCheckoutCommand;
import hu.unideb.prog2.webshop.command.impl.CustomerCartListCommmand;
import hu.unideb.prog2.webshop.command.impl.CustomerProductTypeListCommand;
import hu.unideb.prog2.webshop.dao.impl.ProductDAO;
import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.Cart;

public class UserInteractionControllerFactory {

	public static UserInteractionController create(InputStream input, OutputStream output) {
		// DAO creation
		ProductTypeDAO productTypeDAO = new ProductTypeDAO();
		ProductDAO productDAO = new ProductDAO();
		Cart cart =new Cart();
		// Command creation
		Set<AbstractCommand> commands = new HashSet<>();
		commands.add(new AdminProductTypeImportCommand(productTypeDAO));
		commands.add(new AdminProductTypeListCommand(productTypeDAO));
		commands.add(new AdminProductTypeAddCommand(productTypeDAO));
		commands.add(new AdminProductTypeRemoveCommand(productTypeDAO));
		commands.add(new AdminProductListCommand(productDAO));
		commands.add(new AdminProductAddCommand(productDAO));
		commands.add(new AdminProductRemoveCommand(productDAO));
		commands.add(new AdminProductImportCommand(productDAO));
		commands.add(new CustomerProductTypeListCommand(productTypeDAO));
		commands.add(new CustomerCartAddCommmand(cart));
		commands.add(new CustomerCartListCommmand(cart));
		commands.add(new CustomerCartCheckoutCommand(cart, productDAO, productTypeDAO));
		
		return new UserInteractionController(input, output, commands);
	}
	
}
