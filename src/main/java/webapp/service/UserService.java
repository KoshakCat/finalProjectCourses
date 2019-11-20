package webapp.service;

import dao.UserDao;
import entity.User;

import java.util.Arrays;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    public boolean validateUser (String user, String password) {
        List<User> users = userDao.read();
        System.out.println(users.toArray().toString());
        return users.stream().anyMatch(u -> user.equals(u.getName()) && password.equals(u.getPassword()));
    }
}
