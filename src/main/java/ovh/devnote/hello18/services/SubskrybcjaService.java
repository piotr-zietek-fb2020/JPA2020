package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Subskrybcja;

import java.util.List;

public interface SubskrybcjaService {
    List<Subskrybcja> getAll();
    void save(Subskrybcja subskrybcja);
}
