package hu.unideb.prog2.webshop.model;

public class Product {
	public Product(Integer productTypeId, Integer id) {
		super();
		this.productTypeId = productTypeId;
		Id = id;
	}

	private Integer productTypeId;
	private Integer Id;

	@Override
	public String toString() {
		return "Product [productTypeId=" + productTypeId + ", Id=" + Id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((productTypeId == null) ? 0 : productTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (productTypeId == null) {
			if (other.productTypeId != null)
				return false;
		} else if (!productTypeId.equals(other.productTypeId))
			return false;
		return true;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public Integer getId() {
		return Id;
	}

}
