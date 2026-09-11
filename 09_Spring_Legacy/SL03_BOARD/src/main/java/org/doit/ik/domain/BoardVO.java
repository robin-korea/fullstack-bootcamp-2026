package org.doit.ik.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {

	private Long bno        ;
	private String title      ;
	private String content    ;
	private String writer     ;
	private Date regdate    ;
	private Date updatedate ;

}
