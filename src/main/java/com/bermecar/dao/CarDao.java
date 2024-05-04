package com.bermecar.dao;

import com.bermecar.domain.Car;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface CarDao {

    @SqlQuery("SELECT * FROM cars")
    @UseRowMapper(CarMapper.class)
    List<Car> getAllCars();

    @SqlQuery("SELECT * FROM cars WHERE id = ?")
    @UseRowMapper(CarMapper.class)
    Car getCar(int id);

}
