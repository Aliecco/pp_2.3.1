package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_ID;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USER_ID, "Name1", "111"));
        users.add(new User(++USER_ID, "Name2", "222"));
        users.add(new User(++USER_ID, "Name3", "333"));
        users.add(new User(++USER_ID, "Name4", "444"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_ID);
        users.add(user);
    }
}
