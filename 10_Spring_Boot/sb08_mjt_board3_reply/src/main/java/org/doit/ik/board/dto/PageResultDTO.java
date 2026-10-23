package org.doit.ik.board.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResultDTO<DTO, EN> {
	
	private int totalPage;
	private int page;
	private int size;
	private int start, end;  
	private boolean prev, next;
	private List<Integer> pageList;
	
	private List<DTO> dtoList;
	
	public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {		
		 this.dtoList =	 result.stream()
			    .map(fn)
			    .collect(Collectors.toList());
		
		 this.totalPage = result.getTotalPages();
		 
		 makePageList(result.getPageable());
	}

	private void makePageList(Pageable pageable) {
		
		int pageBlock = 10;
		this.page = pageable.getPageNumber() + 1;  // 1, 2
		this.size = pageable.getPageSize(); 
 
		int currentBlock = (this.page-1)/ pageBlock; 
		this.start = currentBlock * pageBlock + 1;
		this.end =  start  + pageBlock -1;
		if (end > this.totalPage)   end = this.totalPage;		
		this.prev = start > 1;
		this.next = end < this.totalPage;

		this.pageList = IntStream.rangeClosed(start, end)
						.boxed()	                      
						.collect(Collectors.toList());    
	}
	 
}




