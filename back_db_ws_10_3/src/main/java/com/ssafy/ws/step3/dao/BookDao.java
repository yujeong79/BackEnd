package com.ssafy.ws.step3.dao;

import java.util.List;

import com.ssafy.ws.step3.dto.Book;

public interface BookDao {
	
	boolean insert(Book book); // 새로운 책 데이터를 DB에 추가하는 메서드
	
	List<Book> selectAll(); // 책 목록 전체를 가져오는 메서드
	
	Book selectOne(String isbn); // isbn으로 책을 가져오는 메서드
	
	boolean update(Book book); // 책 데이터를 수정하는 메서드
	
	boolean remove(String isbn); // 책 데이터를 삭제하는 메서드
}
