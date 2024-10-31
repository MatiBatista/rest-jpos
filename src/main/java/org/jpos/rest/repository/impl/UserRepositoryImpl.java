package org.jpos.rest.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.jpos.rest.models.User;
import org.jpos.rest.repository.contracts.UserRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UserRepositoryImpl implements UserRepository {

    @Override
    public void addUser(Session session, User user) {
        session.save(user);
    }

    @Override
    public User getUserById(Session session, int id) {
        CriteriaBuilder cb= session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root).where(cb.equal(root.get("id"),id));
        return session.createQuery(cq).uniqueResult();
    }
}
