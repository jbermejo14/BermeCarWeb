package com.svalero.bermecars.dao;

import com.svalero.bermecars.domain.Car;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.*;
import java.util.List;


public interface CarDao {

    @SqlQuery("SELECT * FROM activities")
    @UseRowMapper(CarMapper.class)
    List<Car> getAllActivities();

    @SqlQuery("SELECT * FROM activities WHERE name LIKE CONCAT('%',:searchTerm,'%') " +
            "OR description LIKE CONCAT('%',:searchTerm,'%') OR organizer LIKE CONCAT('%',:searchTerm,'%')")
    @UseRowMapper(CarMapper.class)
    List<Car> getActivities(@Bind("searchTerm") String searchTerm);

    @SqlQuery("SELECT * FROM activities WHERE id = ?")
    @UseRowMapper(CarMapper.class)
    Activity getActivity(int id);

    @SqlUpdate("INSERT INTO activities (name, description, datetime, price, picture) VALUES (?, ?, ?, ?, ?)")
    int addActivity(String name, String description, Date date, float price, String picture);

    @SqlUpdate("UPDATE activities SET name = ?, description = ?, datetime = ?, price = ?, picture = ? WHERE id = ?")
    int updateActivity(String name, String description, Date date, float price, String picture, int id);

    @SqlUpdate("DELETE FROM activities WHERE id = ?")
    int removeActivity(int id);
}
