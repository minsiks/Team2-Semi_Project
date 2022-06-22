package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.ProductBiz;
import com.multi.biz.ReviewBiz;
import com.multi.biz.Shoes_cntBiz;
import com.multi.vo.Filter;
import com.multi.vo.ProductVO;
import com.multi.vo.ReviewVO;
import com.multi.vo.Shoes_cntVO;


@Controller
public class ProductController {
	
	@Autowired
	ProductBiz pbiz;
	
	@Autowired
	Shoes_cntBiz sbiz;
	
	@Autowired
	ReviewBiz rbiz;
	
	@RequestMapping("/men")
	public String men(Model m) {
		List<ProductVO> list3 = null;
		Filter f = new Filter("G", "Men", null, 0, 0, null, null);
		try {
			list3 = pbiz.getfilter(f);
			m.addAttribute("plist", list3);
		} catch (Exception e) {
			e.printStackTrace(); // 오류페이지 제작 필요
		}
		m.addAttribute("center", "product/center");
		m.addAttribute("footer", "footer");
		m.addAttribute("header", "header");
		return "index";
	}
	
	@RequestMapping("/women")
	public String women(Model m) {
		List<ProductVO> list3 = null;
		Filter f = new Filter("G", "Women", null, 0, 0, null, null);
		try {
			list3 = pbiz.getfilter(f);
			m.addAttribute("plist", list3);
		} catch (Exception e) {
			e.printStackTrace(); // 오류페이지 제작 필요
		}
		m.addAttribute("center", "product/center");
		m.addAttribute("footer", "footer");
		m.addAttribute("header", "header");
		return "index";
	}
	
	@RequestMapping("/kids")
	public String kids(Model m) {
		List<ProductVO> list3 = null;
		Filter f = new Filter("G", "Kids", null, 0, 0, null, null);
		try {
			list3 = pbiz.getfilter(f);
			m.addAttribute("plist", list3);
		} catch (Exception e) {
			e.printStackTrace(); // 오류페이지 제작 필요
		}
		m.addAttribute("center", "product/center");
		m.addAttribute("footer", "footer");
		m.addAttribute("header", "header");
		return "index";
	}
	
	@RequestMapping("/productdetail")
	public String productdetail(Model m, int id) {
		ProductVO obj;
		List<Shoes_cntVO> list1;
		List<ReviewVO> list2;
		int staravg;
		int reviewcount;
		try {
			obj = pbiz.get(id);
			list1 = sbiz.getproduct(id);
			list2 = rbiz.getproduct(id);
			staravg = rbiz.getstaravg(id);
			reviewcount = rbiz.getreviewcnt(id);
			
			m.addAttribute("detailproduct", obj);
			m.addAttribute("slist", list1);
			m.addAttribute("rlist", list2);
			m.addAttribute("staravg", staravg);
			m.addAttribute("reviewcount", reviewcount);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "product/detail");
		m.addAttribute("footer", "footer");
		m.addAttribute("header", "header");
		return "index";
	}
	

}
