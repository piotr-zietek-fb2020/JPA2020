package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Wiadomosc;

import java.util.List;

@Repository
public class WiadomoscDAOImpl implements WiadomoscDAO{
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Wiadomosc> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Wiadomosc> query = session.createQuery("from Wiadomosc", Wiadomosc.class);
        return query.getResultList();
    }

    @Override
    public void save(Wiadomosc wiadomosc) {
        Session session = sessionFactory.getCurrentSession();
        session.save(wiadomosc);
    }
}
