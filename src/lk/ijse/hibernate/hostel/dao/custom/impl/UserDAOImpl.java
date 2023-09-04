package lk.ijse.hibernate.hostel.dao.custom.impl;

import lk.ijse.hibernate.hostel.dao.custom.UserDAO;
import lk.ijse.hibernate.hostel.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void setSession(Session session) {

    }

    @Override
    public List<User> loadAll() {
        return null;
    }

    @Override
    public String save(User user) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getObject(String id) throws Exception {
        return null;
    }

    @Override
    public String getPassword(String username) {
        return null;
    }
}
