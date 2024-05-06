package com.bermecar.dao;

import com.bermecar.domain.Reservation;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.Date;
import java.util.List;

public interface ReservationDao {

    @SqlQuery("SELECT * FROM Reservations WHERE Id_users = ?")
    @UseRowMapper(ReservationMapper.class)
    List<Reservation> getReservationByUser(int id_user);

    @SqlQuery("SELECT * FROM Reservations WHERE id = ?")
    @UseRowMapper(ReservationMapper.class)
    Reservation getReservations(int id);

    @SqlUpdate("INSERT INTO Reservations (Datetime, Id_cars, Id_users) VALUES (?, ?, ?)")
    int addReservation(Date datetime, int id_cars, int id_users);
}

