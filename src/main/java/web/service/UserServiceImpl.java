package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDAO;

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public List<User> readUsers() {
        return userDAO.readUsers();
    }

    @Override
    public User readUser(int id) {
        return userDAO.readUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userDAO.deleteUserById(id);
    }
}
