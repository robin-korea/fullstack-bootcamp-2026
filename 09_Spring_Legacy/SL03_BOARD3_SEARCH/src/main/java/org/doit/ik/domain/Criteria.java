package org.doit.ik.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	private String type;    // 검색조건  "tcw"  String [] {"t" / "c" / "w"}
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String [] getTypeArr() {
		return type == null ? new String [] {} : type.split("");
	}
}
