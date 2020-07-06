package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.hello18.dao.ZamowienieSzczegolyDAO;
import ovh.devnote.hello18.entity.ZamowienieSzczegoly;

import javax.transaction.Transactional;

@Service
public class ZamowienieSzczegolyServiceImpl implements ZamowienieSzczegolyService{
    @Autowired
    ZamowienieSzczegolyDAO zamowienieSzczegolyDAO;

    @Transactional
    @Override
    public void save(ZamowienieSzczegoly zamowienieSzczegoly) {
        zamowienieSzczegolyDAO.save(zamowienieSzczegoly);
    }
}
