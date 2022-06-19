package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartVO  {
	private int id;
	private int cnt;
	private String uid;
	private int pid;
	
	// cart insert, update
	public CartVO(int id, int cnt, int pid) {
		this.id = id;
		this.cnt = cnt;
		this.pid = pid;
	}
	// cart delete
	public CartVO(int id) {
		this.id = id;
	}
	
	
	

}
