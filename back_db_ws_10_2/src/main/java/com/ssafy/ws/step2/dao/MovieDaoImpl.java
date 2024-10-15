package com.ssafy.ws.step2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;
import com.ssafy.ws.step2.util.DBUtil;

public class MovieDaoImpl implements MovieDao {
	
	private DBUtil util = DBUtil.getInstance();
	
	private static MovieDaoImpl instance = new MovieDaoImpl();
	private MovieDaoImpl() {}
	
	public static MovieDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Movie> selectAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMovie(Movie movie) throws SQLException {
		String sql = "INSERT INTO movies (id, title, director, genre, runningTime) VALUES (?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movie.getId());
			pstmt.setString(2, movie.getTitle());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getGenre());
			pstmt.setInt(5, movie.getRunningTime());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "명 등록 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);			
		}
		
	}

	@Override
	public int movieCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
