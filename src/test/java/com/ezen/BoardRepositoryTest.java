package com.ezen;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.board.domain.Board;
import com.ezen.board.domain.Member;
import com.ezen.board.domain.Role;
import com.ezen.board.persistence.BoardRepository;
import com.ezen.board.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepo;
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	@Ignore
	public void testInsert() {
		Member member1 = new Member();
		
		member1.setId("member1");
		member1.setPassword("member123");
		member1.setName("홍길동");
		member1.setRole(Role.ROLE_MEMBER);
		member1.setEnabled(true);
		
		memberRepo.save(member1);
		
		Member member2 = new Member();
		
		member2.setId("member2");
		member2.setPassword("member456");
		member2.setName("장보고");
		member2.setRole(Role.ROLE_ADMIN);
		member2.setEnabled(true);
		
		memberRepo.save(member2);
		
		for (int i=1; i<=3; i++) {
			Board board = new Board();
			
			board.setTitle(member1.getName() + "의 게시글" + i);
			board.setContent(member1.getName() + "의 게시글 내용" + i);
			board.setMember(member1);
			
			boardRepo.save(board);	
		}
		
		
		for (int i=1; i<=3; i++) {
			Board board2 = new Board();
			
			board2.setTitle(member2.getName() + "의 게시글" + i);
			board2.setContent(member2.getName() + "의 게시글 내용" + i);
			board2.setMember(member2);
			
			boardRepo.save(board2);
		}
		
	}
	
	@Test
	public void testGetBoard() {
		Optional<Board> optionalBoard = boardRepo.findById(1L);
		
		Board board = optionalBoard.get();
		
		System.out.println(board.getSeq());
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		System.out.println(board.getCnt());
	}
	/*
	@Test
	@Ignore
	public void testGetBoardList() {
		
	}
*/
}
