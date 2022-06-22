package com.multi.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewVO {
	private int id;
	private int pid;
	private int star;
	private String text;
	private Date regdate;
	private String filename;
	private String uid;
	
	//star 평균
	private int staravg;
	
	// review 카운트
	private int count;
	
	//insert
	public ReviewVO(int id, int pid, int star, String text, Date regdate, String uid) {
		this.id = id;
		this.pid = pid;
		this.star = star;
		this.text = text;
		this.regdate = regdate;
		this.uid = uid;
	}
	//delete
	public ReviewVO(int id) {
		this.id = id;
	}
	//update
	public ReviewVO(int id, int star, String text) {
		this.id = id;
		this.star = star;
		this.text = text;
	}
	

	

}