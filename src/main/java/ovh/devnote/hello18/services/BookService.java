package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Ksiazka;

import javax.transaction.Transactional;
import java.util.List;

public interface BookService {
    List<Ksiazka> getBooks();

    List<Ksiazka> getBooksByAutor(int id);

    List<Ksiazka> getBooksByKategoria(int id);

    public void saveBook(Ksiazka ksiazka);

    Ksiazka getBook(int bookid);

    void deleteBook(int bookid);

    List<Ksiazka> getBooksByTytul(String tytul);
}
