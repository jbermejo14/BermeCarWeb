package com.bermecar.dao;

import com.bermecar.domain.Reservation;
import com.bermecar.domain.User;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.Date;
import java.util.List;

public interface ReservationDao {

    @SqlQuery("SELECT * FROM Reservations WHERE id_users = ?")
    @UseRowMapper(ReservationMapper.class)
    List<Reservation> getReservationByUser(int id_users);

    @SqlQuery("SELECT * FROM Reservations")
    @UseRowMapper(ReservationMapper.class)
    List<Reservation> getAllReservations();

    @SqlQuery("SELECT * FROM Reservations WHERE id LIKE '%' || :searchTerm || '%'")
    @UseRowMapper(ReservationMapper.class)
    List<Reservation> getReservations(@Bind("searchTerm") String searchTerm);

    @SqlQuery("SELECT * FROM Reservations WHERE id = ?")
    @UseRowMapper(ReservationMapper.class)
    Reservation getReservation(int id);

    @SqlUpdate("INSERT INTO Reservations (Datetime, id_cars, id_users) VALUES (?, ?, ?)")
    int addReservation(Date datetime, int id_cars, int id_users);

    @SqlUpdate("DELETE FROM Reservations WHERE id = ?")
    int removeReservation(int id);

    @SqlUpdate("UPDATE Reservations SET datetime = ?, id_cars = ?, id_users = ? WHERE id = ?")
    int updateReservation(Date datetime, int id_cars, int id_users, int id);

}

