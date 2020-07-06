package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Autor;

import java.util.List;

public interface AutorDAO {
    List<Autor> getAutorzy();
    void saveAutor(Autor autor);

    Autor getAutor(int id);

    void deleteAutor(int id);
}
