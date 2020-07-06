package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.hello18.dao.WiadomoscDAO;
import ovh.devnote.hello18.entity.Wiadomosc;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WiadomoscServiceImpl  implements WiadomoscService{
    @Autowired
    WiadomoscDAO wiadomoscDAO;

    @Transactional
    @Override
    public List<Wiadomosc> getAll() {
        return wiadomoscDAO.getAll();
    }

    @Transactional
    @Override
    public void saveWiadmosc(Wiadomosc wiadomosc) {
        wiadomoscDAO.save(wiadomosc);
    }
}
