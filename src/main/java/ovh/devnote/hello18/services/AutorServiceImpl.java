package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.hello18.dao.AutorDAO;
import ovh.devnote.hello18.dao.BookDAO;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AutorServiceImpl implements AutorService{
    @Autowired
    AutorDAO autorDAO;
    @Autowired
    BookDAO bookDAO;

    @Override
    @Transactional
    public List<Autor> getAutorzy() {
        List<Autor> autorzyList = autorDAO.getAutorzy();
        return autorzyList;
    }

    @Override
    @Transactional
    public void saveAutor(Autor autor) {
        autorDAO.saveAutor(autor);
    }

    @Override
    @Transactional
    public Autor getAutor(int id) {
        return autorDAO.getAutor(id);
    }

    @Override
    @Transactional
    public void deleteAutor(int id) {
        Autor autor = autorDAO.getAutor(id);
        for (Ksiazka ksiazka: autor.getKsiazki()) {
            ksiazka.removeAutor(autor);
            bookDAO.saveBook(ksiazka);
        }
        autorDAO.deleteAutor(id);
    }

}
