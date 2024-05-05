package com.bermecar.dao;
import com.bermecar.domain.User;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import java.util.List;

public interface UserDao {

    @SqlQuery("SELECT * FROM users")
    @UseRowMapper(UserMapper.class)
    List<User> getAllUsers();

    @SqlQuery("SELECT * FROM users WHERE id = ?")
    @UseRowMapper(UserMapper.class)
    User getUser(int id);

    @SqlQuery("SELECT * FROM users WHERE username = ? AND password = ?")
    @UseRowMapper(UserMapper.class)
    User getUser(String username, String password);

    @SqlUpdate("INSERT INTO users (username, password, telephone, role) VALUES (?, ?, ?, ?)")
    int addUser(String name, String username, String password, String role);

    @SqlUpdate("UPDATE users SET name = ?, username = ?, role = ? WHERE id = ?")
    int updateUser(String name, String username, String role, int id);

    @SqlUpdate("DELETE FROM users WHERE id = ?")
    int removeUser(int id);
}
