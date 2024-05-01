package com.bermecar.dao;

import com.bermecar.domain.Car;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.*;
import java.util.List;

public interface CarDao {

    @SqlQuery("SELECT * FROM CARS")
    @UseRowMapper(CarMapper.class)
    List<Car> getAllCars();

    @SqlQuery("SELECT * FROM cars WHERE name LIKE CONCAT('%',:searchTerm,'%') " +
            "OR description LIKE CONCAT('%',:searchTerm,'%') OR organizer LIKE CONCAT('%',:searchTerm,'%')")
    @UseRowMapper(CarMapper.class)
    List<Car> getCars(@Bind("searchTerm") String searchTerm);

    @SqlQuery("SELECT * FROM cars WHERE id = ?")
    @UseRowMapper(CarMapper.class)
    Car getCar(int id);

    @SqlUpdate("INSERT INTO cars (name, description, datetime, price, picture) VALUES (?, ?, ?, ?, ?)")
    int addCar(String name, String description, Date date, float price, String picture);

    @SqlUpdate("UPDATE cars SET name = ?, description = ?, datetime = ?, price = ?, picture = ? WHERE id = ?")
    int updateCar(String name, String description, Date date, float price, String picture, int id);

    @SqlUpdate("DELETE FROM cars WHERE id = ?")
    int removeCar(int id);
}
