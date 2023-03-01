package com.example.SecondHandShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class SecondHandShopApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void getSumOfCustomerList(){
		Cart cart = new Cart();
		ArrayList<Product> list = cart.getItems();
		list.add(new Product("Product1", "Desc1", 20, "image", Cathegory.HEM, 20));
		list.add(new Product("Product2", "Desc2", 20, "image", Cathegory.HEM, 20));
		list.add(new Product("Product3", "Desc3", 20, "image", Cathegory.HEM, 20));
		Assertions.assertEquals(60, cart.getSum());

		//add 120 to total price
		list.add(new Product("Product4", "Desc4", 120, "image", Cathegory.HEM, 20));
		Assertions.assertEquals(180, cart.getSum());

		//remove product with price 20
		list.remove(1);
		Assertions.assertEquals(160, cart.getSum());

	}
}
