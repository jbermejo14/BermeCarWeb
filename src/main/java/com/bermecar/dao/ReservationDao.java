package com.bermecar.dao;

import com.bermecar.domain.Reservation;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.Date;
import java.util.List;

public interface ReservationDao {

    @SqlQuery("SELECT * FROM Reservation WHERE user_id = ?")
    @UseRowMapper(ReservationMapper.class)
    List<Reservation> getReservationByUser(int userId);

    @SqlQuery("SELECT * FROM Reservation WHERE id = ?")
    @UseRowMapper(ReservationMapper.class)
    Reservation getReservations(int id);

    @SqlUpdate("INSERT INTO Reservation (fecha, price, id_car, id_user) VALUES (?, ?, ?, ?)")
    int addReservation(Date fecha, float price, int Id_car, int Id_user);
}

