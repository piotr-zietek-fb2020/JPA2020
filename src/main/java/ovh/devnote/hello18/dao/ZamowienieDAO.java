package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Zamowienie;

import java.util.List;

public interface ZamowienieDAO {
    List<Zamowienie>getAll();
    List<Zamowienie>getAllForUser(String username);
    void save(Zamowienie zamowienie);
}
