package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.devnote.hello18.dao.SubskrybcjaDAO;
import ovh.devnote.hello18.entity.Subskrybcja;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubskrybcjaServiceImpl implements SubskrybcjaService{
    @Autowired
    SubskrybcjaDAO subskrybcjaDAO;

    @Transactional
    @Override
    public List<Subskrybcja> getAll() {
        return subskrybcjaDAO.getAll();
    }


    @Transactional
    @Override
    public void save(Subskrybcja subskrybcja) {
        subskrybcjaDAO.save(subskrybcja);
    }
}
