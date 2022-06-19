package com.multi.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.CartBiz;
import com.multi.vo.CartVO;

@SpringBootTest
public class CartUpdateTests {

	@Autowired
	CartBiz biz;
	
	@Test
	void contextLoads() {
		CartVO c = new CartVO(5002,3,3005);
		try {
			biz.modify(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
