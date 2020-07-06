package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KategoriaDAOImpl implements KategoriaDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Kategoria> getKategorie() {
        Session session = sessionFactory.getCurrentSession();
        Query<Kategoria> query = session.createQuery("from Kategoria", Kategoria.class);
        List<Kategoria> kategoriaList = query.getResultList();
        return kategoriaList;
    }

    @Override
    public void saveKategoria(Kategoria kategoria) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(kategoria);
    }

    @Override
    public Kategoria getKategoria(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Kategoria> query = session.createQuery("from Kategoria where id = " + id, Kategoria.class);
        Kategoria kategoria = query.getSingleResult();
        return kategoria;
    }

    @Override
    public void deleteKategoria(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Kategoria where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
