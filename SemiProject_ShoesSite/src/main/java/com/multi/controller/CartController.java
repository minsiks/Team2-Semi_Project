package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.Addr_listBiz;
import com.multi.biz.BuyBiz;
import com.multi.biz.Buy_detailBiz;
import com.multi.biz.CartBiz;
import com.multi.vo.Addr_listVO;
import com.multi.vo.BuyVO;
import com.multi.vo.CartVO;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartBiz cartbiz;
	
	@Autowired
	Buy_detailBiz bdbiz;
	
	@Autowired
	Addr_listBiz albiz;
	
	@Autowired
	BuyBiz bbiz;
	
	@RequestMapping("")
	public String cart(Model m) {
		List<CartVO> clist =null;
		try {
			clist = cartbiz.uidselect("id02");
			// 추후삭제 테스트용
			int bid = bbiz.selectid();
			int total = cartbiz.gettotal("id02");
			m.addAttribute("center", "cart/cart");
			m.addAttribute("clist", clist);
			m.addAttribute("total", total);
			//추후 삭제 테스트용
			m.addAttribute("bid", bid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	@RequestMapping("/delete")
	public String delete(Model m,Integer id) {
		try {
			cartbiz.remove(id);
			m.addAttribute("center", "cart/cart");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping("/checkout")
	public String checkout(Model m) { 
		List<CartVO> clist =null;
		Addr_listVO al = null;
		try {
			clist = cartbiz.uidselect("id02");
			int total = cartbiz.gettotal("id02");
			al = albiz.getcustinfo("id02");
			m.addAttribute("center", "cart/checkout");
			m.addAttribute("clist", clist);
			m.addAttribute("total", total);
			m.addAttribute("al", al);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping("buyimpl")
	public String registerimpl(Model m,BuyVO buy) {
		List<CartVO> clist =null;
		try {
			bbiz.register(buy);
			int bid = bbiz.selectid();
			clist = cartbiz.uidselect("id02");
			m.addAttribute("center", "cart/success");
			m.addAttribute("clist", clist);
			m.addAttribute("bid", bid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
}
