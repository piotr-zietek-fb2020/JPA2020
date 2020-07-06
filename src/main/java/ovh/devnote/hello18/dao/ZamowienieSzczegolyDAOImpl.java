package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Zamowienie;
import ovh.devnote.hello18.entity.ZamowienieSzczegoly;

import java.util.List;

@Repository
public class ZamowienieSzczegolyDAOImpl implements ZamowienieSzczegolyDAO{
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void save(ZamowienieSzczegoly zamowienieSzczegoly) {
        Session session = sessionFactory.getCurrentSession();
        session.save(zamowienieSzczegoly);
    }
}
