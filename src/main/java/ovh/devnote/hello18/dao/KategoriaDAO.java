package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Kategoria;

import java.util.List;

public interface KategoriaDAO {
    List<Kategoria> getKategorie();
    void saveKategoria(Kategoria kategoria);

    Kategoria getKategoria(int id);

    void deleteKategoria(int id);
}
