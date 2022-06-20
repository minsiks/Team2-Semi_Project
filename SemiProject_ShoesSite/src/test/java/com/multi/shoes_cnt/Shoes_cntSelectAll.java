package com.multi.shoes_cnt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.Shoes_cntBiz;
import com.multi.vo.Shoes_cntVO;

@SpringBootTest
class Shoes_cntSelectAll {

	@Autowired
	Shoes_cntBiz biz;
	
	@Test
	void contextLoads() {
		List<Shoes_cntVO> list = null;
		try {
			list = biz.get();
			for (Shoes_cntVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

}
