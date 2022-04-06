package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    public List<User> readUsers() {
        return entityManager.createQuery("from " + User.class.getSimpleName(), User.class).getResultList();
    }

    public User readUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
