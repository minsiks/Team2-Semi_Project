package com.multi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.BuyBiz;
import com.multi.biz.CustBiz;
import com.multi.vo.BuyVO;
import com.multi.vo.CustVO;


@Controller
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	CustBiz cust_biz;


	@Autowired
	BuyBiz buy_biz;

	@RequestMapping("")
	public String mypage(Model m) {

		m.addAttribute("left", "mypage/left");
		m.addAttribute("mypage_center", "mypage/center");

		m.addAttribute("center", "mypage/mypage");

		return "index";
	}

	@RequestMapping("buy")//쇼핑정보 - 주문/배송현황 클릭시 실행 
	public String buy(Model m, String id) {
		CustVO cust = null;
		List<BuyVO> list = null;

		System.out.println(id);

		try {
			cust = cust_biz.get(id);
			list = buy_biz.selectUserBuy(id);
			m.addAttribute("buylist", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		m.addAttribute("mypage_center", "mypage/buy");
		m.addAttribute("left", "mypage/left");
		m.addAttribute("center", "mypage/mypage");
		return "index";
	}


	@RequestMapping("review")//활동정보 - 상품리뷰 클릭시 실행  
	public String review(Model m, String id) {
		CustVO cust = null;
		List<BuyVO> list = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		String strcal1="";
		String strcal2="";
		
		
		Date now = new Date();


		cal1.setTime(now);// 시간 설정 
		cal1.add(Calendar.MONTH, -1);// 현재시간부터 1달 뺴기 
		strcal1 = sdf.format(cal1.getTime());
		System.out.println("1달 빼기 : " + strcal1);
		
		
		try {
			now = sdf.parse(strcal1);// 뺀걸 date형으로 변환 
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {
			cust = cust_biz.get(id);
			list = buy_biz.selectUserBuy(id);
			for(BuyVO buy : list) {
//				cal2.setTime(buy.getRegdate());
//				strcal2 = sdf.format(cal2.getTime());
//				System.out.println("buy.regdate : " + strcal2);
				System.out.println(now.after(buy.getRegdate()));
				if(now.after(buy.getRegdate())) {//-1달 이후의 물건만 고름 
					System.out.println(buy);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}




		m.addAttribute("mypage_center", "mypage/review");
		m.addAttribute("left", "mypage/left");
		m.addAttribute("center", "mypage/mypage");
		return "index";
	}


}
