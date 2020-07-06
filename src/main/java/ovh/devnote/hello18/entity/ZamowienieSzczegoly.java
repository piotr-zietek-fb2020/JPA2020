package ovh.devnote.hello18.entity;

import javax.persistence.*;

@Entity(name="zamowienie_szczegoly")
public class ZamowienieSzczegoly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_zamowienia")
    Zamowienie zamowienie;
    @OneToOne
    @JoinColumn(name = "id_ksiazki")
    Ksiazka ksiazka;

    public ZamowienieSzczegoly() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }
}
