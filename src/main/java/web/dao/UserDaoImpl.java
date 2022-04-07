package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> readUsers() {
        return entityManager.createQuery("from " + User.class.getSimpleName(), User.class).getResultList();
    }

    @Override
    public User readUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
