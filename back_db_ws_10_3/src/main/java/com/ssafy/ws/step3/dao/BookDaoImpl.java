package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.util.DBUtil;


/**
 * BookDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
public class BookDaoImpl implements BookDao{
	
	private DBUtil util = DBUtil.getInstance();
	
	// 싱글턴 ////////////////////////////////////////////////////////////
	private BookDaoImpl() {}
	
	private static BookDao instance = new BookDaoImpl();
	
	public static BookDao getInstance() {
		return instance;
	}
	////////////////////////////////////////////////////////////////////

	@Override
	public boolean insert(Book book) {
		String sql = "INSERT INTO book (`isbn`, `title`, `author`, `price`, `desc`, `img`) VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean flag = false;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDesc());
			pstmt.setString(6, book.getImg());
			
			flag = pstmt.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
		System.out.println("도서 삽입 " + flag);
		return flag;
	}

	@Override
	public List<Book> selectAll() {
		List<Book> list = new ArrayList<>();
		
		String sql = "SELECT * FROM book";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setDesc(rs.getString("desc"));
				book.setImg(rs.getString("img"));
				
				list.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public Book selectOne(String isbn) {
		String sql = "SELECT * FROM book WHERE isbn=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Book book = new Book();
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, isbn);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book.setIsbn(isbn);
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setDesc(rs.getString("desc"));
				book.setImg(rs.getString("img"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return book;
	}

	@Override
	public boolean update(Book book) {
		String sql = "UPDATE `book` SET `isbn`=?, `title`=?, `author`=?, `price`=?, `desc`=?, `img`=? WHERE `isbn`=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean success = false;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDesc());
			pstmt.setString(6, book.getImg());
			pstmt.setString(7, book.getIsbn());
			
			success = pstmt.executeUpdate() > 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
		System.out.println("업데이트 : " + success);
		return success;
	}

	@Override
	public boolean remove(String isbn) {
		String sql = "DELETE FROM `book` WHERE `isbn`=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean success = false;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, isbn);
			
			success = pstmt.executeUpdate() > 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
		System.out.println("데이터 삭제 : " + success);
		return success;
	}

}
