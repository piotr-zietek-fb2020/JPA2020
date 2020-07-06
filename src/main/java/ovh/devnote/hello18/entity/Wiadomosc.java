package ovh.devnote.hello18.entity;

import javax.persistence.*;

@Entity
public class Wiadomosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imie;
    private String email;
    private String temat;
    private String wiadomosc;

    public Wiadomosc() {
    }

    public Wiadomosc(String imie, String email, String temat, String wiadomosc) {
        this.imie = imie;
        this.email = email;
        this.temat = temat;
        this.wiadomosc = wiadomosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    @Override
    public String toString() {
        return "Wiadomosc{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", email='" + email + '\'' +
                ", temat='" + temat + '\'' +
                ", wiadomosc='" + wiadomosc + '\'' +
                '}';
    }
}
