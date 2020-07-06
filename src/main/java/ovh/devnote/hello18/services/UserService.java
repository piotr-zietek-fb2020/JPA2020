package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.User;

import javax.transaction.Transactional;

public interface UserService {
    @Transactional
    User getUser(String username);

    @Transactional
    void saveUser(User user);
}
