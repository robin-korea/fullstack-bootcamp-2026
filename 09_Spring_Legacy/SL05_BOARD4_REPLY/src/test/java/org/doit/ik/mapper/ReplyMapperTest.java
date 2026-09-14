package org.doit.ik.mapper;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.stream.IntStream;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	/*
	@Test
	public void testReplyCreate() {
		
		//bno 165 ~ 160
		
		// int n = (int)(Math.random() * 5) + 160;
		IntStream.rangeClosed(1, 30).forEach(i -> {
			int bno = (int)(Math.random() * 5) + 160;
			
			ReplyVO replyVO = new ReplyVO();
			replyVO.setBno((long)bno);
			replyVO.setReply("댓글 테스트" + i);
			replyVO.setReplyer("replyer" + i);
			
			this.replyMapper.insert(replyVO);
			
		});
	}
	*/
	
	@Test
	public void testReplyRead() {
		
		Long rno = 1L;
		System.out.println("🤣🤣🤣" + this.replyMapper.read(rno));
		
	}
		
	
}
