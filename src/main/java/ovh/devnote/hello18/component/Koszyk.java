package ovh.devnote.hello18.component;

import org.springframework.stereotype.Component;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.ArrayList;
import java.util.List;

@Component
public class Koszyk {
    List<Ksiazka> ksiazki = new ArrayList<>();

    public Koszyk() {
    }

    public List<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public void dodajKsiazke(Ksiazka ksiazka) {
        ksiazki.add(ksiazka);
    }

    public void usunKsiazke(int id) {
        ksiazki.removeIf(k->k.getId() == id);
    }
}
