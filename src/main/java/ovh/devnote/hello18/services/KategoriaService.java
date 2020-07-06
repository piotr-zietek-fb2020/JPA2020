package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Kategoria;

import javax.transaction.Transactional;
import java.util.List;

public interface KategoriaService {
    List<Kategoria> getKategorie();
    void saveKategoria(Kategoria kategoria);

    @Transactional
    Kategoria getKategoria(int id);

    @Transactional
    void deleteKategoria(int id);
}
