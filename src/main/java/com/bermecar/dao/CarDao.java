package com.bermecar.dao;

import com.bermecar.domain.Car;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface CarDao {

    @SqlQuery("SELECT * FROM cars")
    @UseRowMapper(CarMapper.class)
    List<Car> getAllCars();

    @SqlQuery("SELECT * FROM cars WHERE id = ?")
    @UseRowMapper(CarMapper.class)
    Car getCar(int id);

    @SqlQuery("SELECT * FROM cars WHERE brand LIKE '%' || :searchTerm || '%' ")
    @UseRowMapper(CarMapper.class)
    List<Car> getCars(@Bind("searchTerm") String searchTerm);

    @SqlUpdate("INSERT INTO cars (license_plate, brand, model, country, year, price, photo) VALUES (?, ?, ?, ?, ?, ?)")
    int addCar(String license_plate, String brand, String model, String country, int year, float price, String picture);

    @SqlUpdate("UPDATE cars SET license_plate = ?, brand = ?, model = ?, country = ?, year = ?, price = ?, photo = ? WHERE id = ?")
    int updateCar(String license_plate, String brand, String model, String country, int year, float price, String picture, int id);


}
