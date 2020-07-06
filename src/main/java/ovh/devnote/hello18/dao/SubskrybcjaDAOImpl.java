package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Subskrybcja;
import ovh.devnote.hello18.entity.Wiadomosc;

import java.util.List;

@Repository
public class SubskrybcjaDAOImpl implements SubskrybcjaDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Subskrybcja> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Subskrybcja> query = session.createQuery("from Subskrybcja", Subskrybcja.class);
        return query.getResultList();
    }

    @Override
    public void save(Subskrybcja subskrybcja) {
        Session session = sessionFactory.getCurrentSession();
        session.save(subskrybcja);
    }
}
