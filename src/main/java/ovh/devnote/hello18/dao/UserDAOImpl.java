package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.User;

import javax.persistence.NoResultException;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getUser(String name) {
        Session session = sessionFactory.getCurrentSession();
        User user;
        try {
            Query<User> query = session.createQuery("from User u where u.username = :username", User.class);
            query.setParameter("username", name);
            System.out.println("OK");
            user = query.getSingleResult();
        } catch (NoResultException e) {
            return  null;
        }
        return user;
    }
}
