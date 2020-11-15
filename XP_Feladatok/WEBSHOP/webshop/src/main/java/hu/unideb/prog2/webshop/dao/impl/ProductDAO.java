package hu.unideb.prog2.webshop.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.unideb.prog2.webshop.dao.DataAccessObject;
import hu.unideb.prog2.webshop.model.Product;

public class ProductDAO implements DataAccessObject<Product> {

	private Map<Integer, Map<Integer, Product>> productHolderMap;

	public ProductDAO() {
		super();
		this.productHolderMap = new HashMap<>();
	}

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		if (productHolderMap.containsKey(product.getProductTypeId())) {
			productHolderMap.get(product.getProductTypeId()).put(product.getId(), product);
		} else {
			productHolderMap.put(product.getProductTypeId(), new HashMap<>());
			productHolderMap.get(product.getProductTypeId()).put(product.getId(), product);
		}
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		for (Integer producteType : productHolderMap.keySet()) {

			if (productHolderMap.get(producteType).containsKey(id)) {
				productHolderMap.get(producteType).remove(id);
				break;
			}

		}
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub

		List<Product> productList = new ArrayList<>();

		for (Integer iterable_element : productHolderMap.keySet()) {
			productList.addAll(productHolderMap.get(iterable_element).values());

		}

		return productList;
	}

	

	public Integer buying(Integer typeId) throws Exception {

		if (productHolderMap.containsKey(typeId)) {
			Integer producteId = (Integer) productHolderMap.get(typeId).keySet().toArray()[0];
			if (producteId != null)
				productHolderMap.get(typeId).remove(productHolderMap.get(typeId).keySet().toArray()[0]);
			return producteId;
			// Give back null if no product of this type
		} else {
			throw new Exception(typeId.toString() + "is a wrong typeId");
		}

	}

}
