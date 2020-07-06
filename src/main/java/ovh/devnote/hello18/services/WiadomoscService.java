package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Wiadomosc;

import java.util.List;

public interface WiadomoscService {
    List<Wiadomosc> getAll();
    void saveWiadmosc(Wiadomosc wiadomosc);
}
