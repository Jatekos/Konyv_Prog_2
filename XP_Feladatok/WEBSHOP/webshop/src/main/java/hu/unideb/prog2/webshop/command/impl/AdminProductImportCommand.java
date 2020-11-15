package hu.unideb.prog2.webshop.command.impl;

import java.io.FileNotFoundException;

import hu.unideb.prog2.webshop.dao.impl.ProductDAO;
import hu.unideb.prog2.webshop.model.Product;
import hu.unideb.prog2.webshop.reader.CsvRead;

public class AdminProductImportCommand extends AbstractCommand {

	private ProductDAO productDAO;

	public AdminProductImportCommand(ProductDAO productDAO) {
		super("admin", "product", "import");
		// TODO Auto-generated constructor stub
		this.productDAO = productDAO;
	}
	@Override
	public String process(String[] commandString) {
		// TODO Auto-generated method stub
		CsvRead csvRead =new CsvRead();
		try {
			csvRead.readar(commandString[3]).forEach(x -> productDAO.create(new Product(Integer.parseInt(x[0]), Integer.parseInt(x[1]))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return("wrong file name"+ commandString[3]);
		}
		return "AdminProductImport ids callde";
	}

}
