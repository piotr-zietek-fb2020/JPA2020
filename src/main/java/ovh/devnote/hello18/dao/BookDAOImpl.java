package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Ksiazka> getBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = session.createQuery("select k from Ksiazka k", Ksiazka.class);
        List<Ksiazka> books = query.getResultList();
        return books;
    }

    @Override
    public void saveBook(Ksiazka ksiazka) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(ksiazka);
    }

    @Override
    public Ksiazka getBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = session.createQuery("from Ksiazka where id = " + id, Ksiazka.class);
        Ksiazka book = query.getSingleResult();
        return book;
    }

    @Override
    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Ksiazka where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Ksiazka> getBooksByTutul(String tytul) {
        Session session = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = session.createQuery("select k from Ksiazka k where k.nazwa like :tytul", Ksiazka.class);
        query.setParameter("tytul", "%" + tytul + "%");
        return query.getResultList();
    }

}
