package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@RestController
public class AJAXController {

	@Autowired
	CustBiz cbiz;
	
	@RequestMapping("gettotal")
	public int gettotal(
			@RequestParam(value="price[]") List<Integer> price, 
			@RequestParam(value="count[]") List<Integer> count){
			
			int result = 0;
			for (Integer integer : count) {
				result += integer;
			}
		return result;
	}

	
	@RequestMapping("/checkid")
	public String checkid(String id) {
		CustVO cust = null;
		List<CustVO> list = null;
		String result = "0";
		
		try {
			list = cbiz.get();
			for(CustVO c : list) {
				if(c.getId().equals(id) || id.equals("")) {//id 같은것이 있다면 1을 리턴 -> 1이면 사용불가 
					result = "1";
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	

}
