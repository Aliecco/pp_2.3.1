package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void updateUser(User user);

    List<User> readUsers();

    User readUser(int id);

    void saveUser(User user);

    void deleteUserById(int id);
}