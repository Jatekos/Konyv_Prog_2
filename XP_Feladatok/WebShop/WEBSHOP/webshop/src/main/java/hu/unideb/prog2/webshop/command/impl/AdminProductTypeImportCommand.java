package hu.unideb.prog2.webshop.command.impl;

import java.io.FileNotFoundException;

import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.ProductType;
import hu.unideb.prog2.webshop.reader.CsvRead;

public class AdminProductTypeImportCommand extends AbstractCommand {

	private ProductTypeDAO productTypeDAO;

	public AdminProductTypeImportCommand(ProductTypeDAO productTypeDAO) {
		super("admin", "product_type", "import");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String[] commandString) {
		CsvRead csvRead = new CsvRead();

		try {
			csvRead.readar(commandString[3])
					.forEach(x -> productTypeDAO.create(new ProductType(x[0], x[1], x[2], Integer.parseInt(x[3]))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ("wrong file name" + commandString[3]);
		}
		return "AdminProductTypeImportCommand is called";
	}

}
