package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Autor;

import javax.transaction.Transactional;
import java.util.List;

public interface AutorService {
    List<Autor> getAutorzy();
    void saveAutor(Autor autor);

    @Transactional
    Autor getAutor(int id);

    @Transactional
    void deleteAutor(int id);
}
