package com.ssafy.ws.step2.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;

public interface MovieDao {
	
	List<Movie> selectAllMovies() throws SQLException;
	
	boolean insertMovie(Movie movie) throws SQLException;
	
	int movieCount() throws SQLException;
}