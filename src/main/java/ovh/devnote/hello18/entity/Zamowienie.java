package ovh.devnote.hello18.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;

@Entity
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private float kwota;
    private Date data;
    @OneToMany(mappedBy = "zamowienie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<ZamowienieSzczegoly> zamowienieSzczegolyList;


    public Zamowienie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ZamowienieSzczegoly> getZamowienieSzczegolyList() {
        return zamowienieSzczegolyList;
    }

    public void setZamowienieSzczegolyList(List<ZamowienieSzczegoly> zamowienieSzczegolyList) {
        this.zamowienieSzczegolyList = zamowienieSzczegolyList;
    }


}
