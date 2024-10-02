package com.ssafy.ws.step1.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step1.dto.Car;

public interface CarDao {
	
	List<Car> selectAllCars() throws SQLException;
	
	boolean insertCar(Car car) throws SQLException;
	
	int carCount() throws SQLException;
}
