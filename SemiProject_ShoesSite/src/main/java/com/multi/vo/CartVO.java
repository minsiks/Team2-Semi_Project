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
	private int count;
	private String uid;
	private int pid;
	private int size;
	private String pname;
	private String pprice;
	private String pimg1;
	private int total;
	
	// cart insert, update
	public CartVO(int id, int count, int pid) {
		this.id = id;
		this.count = count;
		this.pid = pid;
	}
	// cart delete
	public CartVO(int id) {
		this.id = id;
	}
}
