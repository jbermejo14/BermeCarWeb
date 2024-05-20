package com.bermecar.dao;
import com.bermecar.domain.Car;
import com.bermecar.domain.User;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import java.util.List;

public interface UserDao {

    @SqlQuery("SELECT * FROM users")
    @UseRowMapper(UserMapper.class)
    List<User> getAllUsers();

    @SqlQuery("SELECT * FROM users WHERE username LIKE '%' || :searchTerm || '%' OR role LIKE '%' || :searchTerm || '%'")
    @UseRowMapper(UserMapper.class)
    List<User> getUsers(@Bind("searchTerm") String searchTerm);

    @SqlQuery("SELECT * FROM users WHERE id = ?")
    @UseRowMapper(UserMapper.class)
    User getUser(int id);

    @SqlQuery("SELECT * FROM users WHERE username = ? AND password = ?")
    @UseRowMapper(UserMapper.class)
    User getUser(String username, String password);

    @SqlUpdate("INSERT INTO users (username, password, email, telephone, role) VALUES (?, ?, ?, ?, ?)")
    int addUser(String username, String password, String email, int telephone, String role);

    @SqlUpdate("UPDATE users SET username = ?, password = ?, email = ?, telephone = ? WHERE id = ?")
    int updateUser(String username, String password, String email, int telephone, int id);

    @SqlUpdate("DELETE FROM users WHERE id = ?")
    int removeUser(int id);
}