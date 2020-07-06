package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Zamowienie;

import java.util.List;

public interface ZamowienieService {
    List<Zamowienie> getAll();
    List<Zamowienie>getAllForUser(String username);
    void save(Zamowienie zamowienie);
}
