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
        // Obtenemos los IDs de usuario y coche de la reserva
        int userId = rs.getInt("id_users");
        int carId = rs.getInt("id_cars");

        // Obtenemos los objetos de usuario y coche de la base de datos utilizando los IDs
        User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(userId));
        Car car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(carId));

        // Creamos y devolvemos el objeto Reservation
        return new Reservation(
                rs.getInt("ID"), // ID de la reserva
                rs.getDate("Datetime"), // Fecha y hora de la reserva
                car, // Objeto Car asociado a la reserva
                user // Objeto User asociado a la reserva
        );
    }
}
