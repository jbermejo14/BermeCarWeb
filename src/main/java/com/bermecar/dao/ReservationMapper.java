package com.bermecar.dao;

import com.bermecar.domain.Car;
import com.bermecar.domain.Reservation;
import com.bermecar.domain.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapper implements RowMapper<Reservation> {

    @Override
    public Reservation map(ResultSet rs, StatementContext ctx) throws SQLException {
        Car car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(rs.getInt("id")));
        User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(rs.getInt("id")));

        return new Reservation(rs.getInt("id"),
                rs.getDate("datetime"),
                car,
                user);
    }
}
