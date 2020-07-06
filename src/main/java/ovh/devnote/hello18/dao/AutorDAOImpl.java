package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Kategoria;

import java.util.List;

@Repository
public class AutorDAOImpl implements AutorDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Autor> getAutorzy() {
        Session session = sessionFactory.getCurrentSession();
        Query<Autor> query = session.createQuery("from Autor", Autor.class);
        List<Autor> autorzyList = query.getResultList();
        return autorzyList;
    }

    @Override
    public void saveAutor(Autor autor) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(autor);
    }

    @Override
    public Autor getAutor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Autor> query = session.createQuery("from Autor where id = " + id, Autor.class);
        Autor autor = query.getSingleResult();
        return autor;
    }

    @Override
    public void deleteAutor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Autor where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
