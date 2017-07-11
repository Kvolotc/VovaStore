package store.persistence.model;

import store.persistence.entity.enums.Product;

public class ProductParam {
	
	private int productId;
	
	private int amount;
	
	private String product;
	
	private int sumPurchase;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getSumPurchase() {
		return sumPurchase;
	}

	public void setSumPurchase(int sumPurchase) {
		this.sumPurchase = sumPurchase;
	}

	@Override
	public String toString() {
		return "ProductParam [id=" + productId + ", amount=" + amount + ", product=" + product + ", sumPurchase=" + sumPurchase
				+ "]";
	}
	
}
