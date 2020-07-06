package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.User;

public interface UserDAO {
    void saveUser(User user);

    User getUser(String username);
}
