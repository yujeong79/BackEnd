package com.ssafy.ws.step2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;
import com.ssafy.ws.step2.util.DBUtil;

public class MovieDaoImpl implements MovieDao {
	
	private final DBUtil util = DBUtil.getInstance();
	
	private static MovieDaoImpl instance = new MovieDaoImpl();
	
	private MovieDaoImpl() {}
	
	public static MovieDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Movie> selectAllMovies() throws SQLException{
		String sql = "SELECT * FROM movies";
		List<Movie> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setTitle(rs.getString("title"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setRunningTime(rs.getInt("runningTime"));
				
				list.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public boolean insertMovie(Movie movie) throws SQLException {
		String sql = "INSERT INTO movies (title, director, genre, runningTime) VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getGenre());
			pstmt.setInt(4, movie.getRunningTime());
			
			result = pstmt.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);			
		}
		
		System.out.println("insert 결과 : " + result);
		return result;
	}

	@Override
	public int movieCount() throws SQLException {
		String sql = "SELECT COUNT(*) FROM movies";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}
		
		return count;
	}
}
