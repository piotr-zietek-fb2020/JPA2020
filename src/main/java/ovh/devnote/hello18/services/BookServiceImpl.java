package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.hello18.dao.BookDAO;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookDAO bookDAO;
    @Autowired
    AutorService autorService;
    @Autowired
    KategoriaService kategoriaService;


    @Override
    @Transactional
    public List<Ksiazka> getBooks() {
        List<Ksiazka> books = bookDAO.getBooks();
        return books;
    }

    @Override
    @Transactional
    public List<Ksiazka> getBooksByAutor(int id) {
        Autor autor = autorService.getAutor(id);
        List<Ksiazka> books = new ArrayList<>();
        books.addAll(autor.getKsiazki());
        return books;
    }

    @Override
    @Transactional
    public List<Ksiazka> getBooksByKategoria(int id) {
        Kategoria kategoria = kategoriaService.getKategoria(id);
        return kategoria.getKsiazki();
    }

    @Transactional
    @Override
    public List<Ksiazka> getBooksByTytul(String tytul) {
        return bookDAO.getBooksByTutul(tytul);
    }

    @Override
    @Transactional
    public void saveBook(Ksiazka ksiazka) {
        bookDAO.saveBook(ksiazka);
    }

    @Override
    @Transactional
    public Ksiazka getBook(int bookid) {
        return bookDAO.getBook(bookid);
    }

    @Override
    @Transactional
    public void deleteBook(int bookid) {
        Ksiazka ksiazka = bookDAO.getBook(bookid);
        ksiazka.setKategoria(null);
        for (Autor autor: ksiazka.getAutorzy()) {
            ksiazka.removeAutor(autor);
        }
        bookDAO.deleteBook(bookid);
    }




}
