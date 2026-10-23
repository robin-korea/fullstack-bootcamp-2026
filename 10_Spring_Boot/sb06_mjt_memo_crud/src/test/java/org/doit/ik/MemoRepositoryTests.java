package org.doit.ik;

import java.util.stream.IntStream;

import org.doit.ik.memo.Memo;
import org.doit.ik.memo.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemoRepositoryTests {
	
	@Autowired
	private MemoRepository memoRepository;
	
	// [1] memoRepsitory 객체 확인
	@Test
	void contextLoads() {
		System.out.println("🤣🤣🤣" + this.memoRepository.getClass().getName());
	}
	
	// [2] 더미데이터 추가 
	@Test
	void testInsertDummies() {
		IntStream
			.rangeClosed(1, 256)
			.forEach( i -> {
				Memo entity = Memo.builder()
									.memoText("Sample Memo..." + i)
									.build();
				this.memoRepository.save(entity);
			});
	}
	

}
