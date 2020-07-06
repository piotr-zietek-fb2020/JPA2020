package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.hello18.dao.BookDAO;
import ovh.devnote.hello18.dao.KategoriaDAO;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class KategoriaServiceImpl implements KategoriaService {
    @Autowired
    KategoriaDAO kategoriaDAO;
    @Autowired
    BookDAO bookDAO;

    @Override
    @Transactional
    public List<Kategoria> getKategorie() {
        List<Kategoria> kategorieList = kategoriaDAO.getKategorie();
        return kategorieList;
    }

    @Override
    @Transactional
    public void saveKategoria(Kategoria kategoria) {
        kategoriaDAO.saveKategoria(kategoria);
    }

    @Override
    @Transactional
    public Kategoria getKategoria(int id) {
        return kategoriaDAO.getKategoria(id);
    }

    @Override
    @Transactional
    public void deleteKategoria(int id) {
        Kategoria kategoria = kategoriaDAO.getKategoria(id);
        for (Ksiazka ksiazka : kategoria.getKsiazki()) {
            ksiazka.setKategoria(null);
            bookDAO.saveBook(ksiazka);
        }
        kategoria.setKsiazki(null);
        kategoriaDAO.deleteKategoria(id);
    }

}
