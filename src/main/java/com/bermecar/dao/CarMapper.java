package com.svalero.bermecars.dao;

import com.svalero.bermecars.domain.Car;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car map(ResultSet rs, StatementContext ctx) throws SQLException {
        Car coche = new Car();
        coche.getMatricula(rs.getString("matricula"));
        coche.getMarca(rs.getString("marca"));
        coche.getModelo(rs.getString("modelo"));
        coche.getPais(rs.getString("pais"));
        coche.getAño(rs.getString("año"));
        coche.getNIF(rs.getString("NIF"));
        coche.getFoto(rs.getString("foto"));
        return coche;
}

