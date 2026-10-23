package org.doit.ik.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
	
	private Long rno;
	private String text;
	private String replyer;
	private Long bno;
	private LocalDateTime regDate;
	private LocalDateTime modDate;

}
