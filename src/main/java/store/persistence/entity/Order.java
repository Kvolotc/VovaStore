package store.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import store.persistence.entity.enums.Payment;
import store.persistence.entity.enums.Product;
import store.persistence.model.ProductParam;

@Entity
@Table(name = "orders")
public class Order {
	
	public Order() {}
	
	public Order(ProductParam productParam, User user, String contry, String city, int newPost, String payment) {

		this.user = user;
		this.contry = contry;
		this.city = city;
		this.newPost = newPost;
		this.productId = productParam.getProductId();
		this.product = Product.getEnumByValue(productParam.getProduct());
		this.amountProducts = productParam.getAmount();
		this.sumPurchase = productParam.getSumPurchase();
		this.dateOfPurchase = new Timestamp(System.currentTimeMillis());
		this.payment = Payment.getEnumByValue(payment);
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;
	
	@Column(name="product_id")
	private int productId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="product")
	private Product product;
	
	@Column(name="contry")
	private String contry;
	
	@Column(name="city")
	private String city;
	
	@Column(name="new_post")
	private int newPost;
	
	@Column(name = "amount_products")
	private int amountProducts;
	
	@Column(name = "sum_purchase")
	private int sumPurchase;
	
	@Column(name="date_of_purchase")
	private Timestamp dateOfPurchase;
	
	@Column(name="type_of_payment")
	@Enumerated(EnumType.STRING)
	private Payment payment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmountProducts() {
		return amountProducts;
	}

	public void setAmountProducts(int amountProducts) {
		this.amountProducts = amountProducts;
	}

	public int getSumPurchase() {
		return sumPurchase;
	}

	public void setSumPurchase(int sumPurchase) {
		this.sumPurchase = sumPurchase;
	}

	public Timestamp getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Timestamp dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
