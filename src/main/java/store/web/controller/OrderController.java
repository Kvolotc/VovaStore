package store.web.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.entity.Order;
import store.persistence.model.ProductParam;
import store.persistence.model.PurchaseProduct;
import store.service.OrderServise;
import store.service.UserService;

@RestController
public class OrderController {

	@Autowired
	private OrderServise servise;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/purchaseProduct", method = RequestMethod.POST)
	public void purchaseProduct(@RequestBody PurchaseProduct purchaseProduct) {

		System.out.println(purchaseProduct);
		Iterator<ProductParam> products = purchaseProduct.iterator();

		while (products.hasNext()) {
			ProductParam product = products.next();
			Order order = new Order(product, userService.findById(purchaseProduct.getUserId()),
					purchaseProduct.getContry(), purchaseProduct.getCity(), purchaseProduct.getNewPost(),
					purchaseProduct.getPayment());
			servise.save(order);

		}

	}
}
