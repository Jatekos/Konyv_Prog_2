package hu.unideb.prog2.webshop.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.unideb.prog2.webshop.dao.DataAccessObject;
import hu.unideb.prog2.webshop.model.ProductType;

public class ProductTypeDAO implements DataAccessObject<ProductType> {

	private Map<Integer, ProductType> productTypeMap;
	private int idIndex = 0;
	
	public ProductTypeDAO() {
		productTypeMap = new HashMap<>();
	}

	public void create(ProductType productType) {
		int id =idIndex++;
		productType.setId(id);
		productTypeMap.put(id, productType);
	}

	public void remove(Integer id) {
		productTypeMap.remove(id);
	}

	public List<ProductType> list() {
		return new ArrayList<>(productTypeMap.values());
	}
	
	public Integer getPrice(Integer id) {
		return productTypeMap.get(id).getPrice();
	}

}
