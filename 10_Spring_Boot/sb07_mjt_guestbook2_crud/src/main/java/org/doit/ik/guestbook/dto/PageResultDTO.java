package org.doit.ik.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResultDTO<DTO, EN> {	// 제네릭 클래스
	
	private int totalPage;
	private int page;                // 현재 페이지 번호
	private int size;				 // 한 페이지에 출력할 방명록 수
	private int start, end;          // start              end    
	private boolean prev, next;	     //                        next
	private List<Integer> pageList;  // [1] 2 3 4 5 6 7 8 9 10 >>
	
	private List<DTO> dtoList;
	
	// Page<Guestbook> -> List<GuestbookDTO> 변환....  생성자
	public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {		
		 this.dtoList =	 result.stream()
			    .map(fn)
			    .collect(Collectors.toList()); //  List<GuestbookDTO>
		
		 this.totalPage = result.getTotalPages(); // 총 페이지 수
		 
		 makePageList(result.getPageable());
	}

	// start, end, prev, next 
	// pageList
	private void makePageList(Pageable pageable) {
		
		int pageBlock = 10;
		this.page = pageable.getPageNumber() + 1;  // 1, 2
		this.size = pageable.getPageSize(); 
		// 
		int currentBlock = (this.page-1)/ pageBlock; 
		this.start = currentBlock * pageBlock + 1;
		this.end =  start  + pageBlock -1;
		if (end > this.totalPage)   end = this.totalPage;		
		this.prev = start > 1;
		this.next = end < this.totalPage;
		// 
		this.pageList = IntStream.rangeClosed(start, end) // IntStram
						.boxed()	                      // Stream<Integer>
						.collect(Collectors.toList());    // List<Integer>
	}
	 
}




