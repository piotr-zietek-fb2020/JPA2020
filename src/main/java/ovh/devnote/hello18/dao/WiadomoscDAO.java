package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Wiadomosc;

import java.util.List;

public interface WiadomoscDAO {
    List<Wiadomosc> getAll();
    void save(Wiadomosc wiadomosc);
}
