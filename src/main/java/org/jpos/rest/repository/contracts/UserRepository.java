package org.jpos.rest.repository.contracts;

import org.glassfish.jersey.spi.Contract;
import org.hibernate.Session;
import org.jpos.rest.models.User;

public interface UserRepository {

    void addUser(Session session, User user);

    User getUserById(Session session, int id);
}
