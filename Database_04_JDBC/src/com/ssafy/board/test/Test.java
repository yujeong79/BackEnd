package com.ssafy.board.test;

import java.util.List;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
		System.out.println(dao.selectOne(1));
		
		Board board = new Board("이제는 알아야해01", "양강사", "Java문법 이제는 정말 알아야죠");
		
		dao.insertBoard(board);
		for(int i = 0; i < 100; i++) {
			Board boards = new Board("이제는 알아야해"+i, "양강사", "Java문법 이제는 정말 알아야죠");
			dao.insertBoard(boards);
		}
		
		dao.deleteBoard(1);
		
		for(Board b : dao.selectAll()) {
			System.out.println(b);
		}
		
		dao.updateBoard(new Board(2, "제목수정", "작성자수정", "내용수정", null, 0));
		System.out.println(dao.selectOne(2));
		
		dao.updateViewCnt(2);
		dao.updateViewCnt(2);
		System.out.println(dao.selectOne(2));
	}
}
