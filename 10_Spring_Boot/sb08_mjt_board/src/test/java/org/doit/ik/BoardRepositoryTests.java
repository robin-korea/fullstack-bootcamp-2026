package org.doit.ik;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.doit.ik.board.entity.Board;
import org.doit.ik.board.entity.Member;
import org.doit.ik.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	void insertBoards() {
		
		IntStream.rangeClosed(1, 100).forEach(i -> {
			
			Member writer = Member.builder()
					.email("user"+i+"@aaa.com")
					.build();
			
			Board entity = Board.builder()
					.title("title..."+ i)
					.content("content..."+ i)
					.writer(writer)
					.build();
			this.boardRepository.save(entity);
		});
		
		System.out.println("🤣🤣🤣 END");	
	}
	
	@Test
	@Transactional
	void testRead1() {
		// 100번 게시글 정보를 상세보기(조회)
		Long bno = 100L;
		Optional<Board> o_board = this.boardRepository.findById(bno);
		Board board = o_board.get();
		System.out.println("🤣🤣🤣" + board);
		
		// 작성자 정보 조회
		Member writer = board.getWriter();
		System.out.println("🤣🤣🤣" + writer);
	}
	
	@Test
	void testGetBoardWithWriter() {
		Long bno = 100L;
		Object result = this.boardRepository.getBoardWithWriter(bno);
		Object [] arr = (Object[])result;
		System.out.println("👌👌👌");
		System.out.println(Arrays.toString(arr));
		System.out.println("👌👌👌");
	}
	
	@Test
	void testGetBoardWithReply() {
		Long bno = 100L;
		List<Object[]> result = this.boardRepository.getBoardWithReply(bno);
		for (Object[] arr : result) {
			System.out.println("😂😂😂" + Arrays.toString(arr));
		}
	}
	
	@Test
	void testGetBoardWithReplyCount() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
		Page<Object []>result = this.boardRepository.getBoardWithReplyCount(pageable);
		
		result.get().forEach(row -> {
			Object [] arr = (Object[])row;
			System.out.println(Arrays.toString(arr));
		});
	}
	
	@Test
	void getBoardByBno() {
		Object result = this.boardRepository.getBoardByBno(11L);
		Object[] arr = (Object[])result;
		System.out.println(Arrays.toString(arr));
	}
	
}
