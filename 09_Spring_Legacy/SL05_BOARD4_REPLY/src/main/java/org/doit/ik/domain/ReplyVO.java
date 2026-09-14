package org.doit.ik.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReplyVO {

	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;

}
