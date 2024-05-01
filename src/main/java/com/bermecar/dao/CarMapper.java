package com.bermecar.dao;

import com.bermecar.domain.Car;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Car(rs.getString("license_plate"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getString("country"),
                rs.getInt("year"),
                rs.getFloat("price"),
                rs.getString("photo"));
    }
}

