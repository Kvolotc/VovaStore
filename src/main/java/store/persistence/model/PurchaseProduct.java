package store.persistence.model;

import java.util.Arrays;
import java.util.Iterator;

public class PurchaseProduct implements Iterable<ProductParam> {

	private int userId;

	private String contry;

	private String city;

	private int newPost;

	private String payment;

	private ProductParam[] productParams;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ProductParam[] getProductParams() {
		return productParams;
	}

	public void setProductParams(ProductParam[] productParams) {
		this.productParams = productParams;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNewPost() {
		return newPost;
	}

	public void setNewPost(int newPost) {
		this.newPost = newPost;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "PurchaseProduct [userId=" + userId + ", contry=" + contry + ", city=" + city + ", newPost=" + newPost
				+ ", payment=" + payment + ", productParams=" + Arrays.toString(productParams) + "]";
	}

	@Override
	public Iterator<ProductParam> iterator() {

		return new Iterator<ProductParam>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < productParams.length && productParams[currentIndex] != null;
			}

			@Override
			public ProductParam next() {
				return productParams[currentIndex++];
			}
		};
	}
}
