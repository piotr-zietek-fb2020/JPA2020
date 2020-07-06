package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Zamowienie;

import java.util.List;

@Repository
public class ZamowienieDAOImpl implements ZamowienieDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Zamowienie> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Zamowienie> query = session.createQuery("select z from Zamowienie z", Zamowienie.class);
        List<Zamowienie> zamowienieList = query.getResultList();
        return zamowienieList;
    }

    @Override
    public List<Zamowienie> getAllForUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Zamowienie> query = session.createQuery("select z from Zamowienie z where z.username = :username", Zamowienie.class);
        query.setParameter("username", username);
        List<Zamowienie> zamowienieList = query.getResultList();
        return zamowienieList;
    }

    @Override
    public void save(Zamowienie zamowienie) {
        Session session = sessionFactory.getCurrentSession();
        session.save(zamowienie);
    }
}
