package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
public class CartInsertTests {

@Autowired
CartBiz cartbiz;

@Test
void contextLoads() {
	CartVO cart = new CartVO(5005,3,3001);
		try {
			cartbiz.register(cart);
			System.out.println(cart);
			System.out.println("Insert Complited");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
