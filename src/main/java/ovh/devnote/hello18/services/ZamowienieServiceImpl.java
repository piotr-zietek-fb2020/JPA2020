package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.hello18.dao.ZamowienieDAO;
import ovh.devnote.hello18.entity.Zamowienie;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
public class ZamowienieServiceImpl implements ZamowienieService{
    @Autowired
    ZamowienieDAO zamowienieDAO;

    @Transactional
    @Override
    public List<Zamowienie> getAll() {
        return zamowienieDAO.getAll();
    }

    @Transactional
    @Override
    public List<Zamowienie> getAllForUser(String username) {
        return zamowienieDAO.getAllForUser(username);
    }

    @Transactional
    @Override
    public void save(Zamowienie zamowienie) {
        zamowienieDAO.save(zamowienie);
    }
}
