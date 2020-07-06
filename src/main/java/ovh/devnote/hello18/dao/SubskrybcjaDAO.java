package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Subskrybcja;

import java.util.List;

public interface SubskrybcjaDAO {
    List<Subskrybcja>getAll();
    void save(Subskrybcja subskrybcja);
}
