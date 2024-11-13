package org.jpos.rest.participants;

import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.ee.DB;

import org.jpos.rest.models.User;
import org.jpos.rest.repository.contracts.UserRepository;
import org.jpos.rest.repository.impl.UserRepositoryImpl;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;


import java.io.Serializable;


public class Prueba extends TxnSupport {

    private String groupName;


    private UserRepositoryImpl userRepository;


    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
        this.groupName=cfg.get("group-name");
        this.userRepository=new UserRepositoryImpl();
    }

    @Override
    public int prepare(long id, Serializable o) {
            Context ctx = (Context) o;
            info("ESTO ES UNA PRUEBA DE LA TRANSACCION " + groupName);
            org.jpos.ee.DB db= getDB(ctx);
            User user=userRepository.getUserById(db.session(),1);
            info(user.getName());
            if (groupName.equals("sendOtp")) {
               // ctx.put(REJECTION_REASON,Thales_Response_Status.CARD_REVOKED_OR_DELETED.name());
                //throw new BadRequestException(Thales_Response_Status.CARD_SUSPENDED);
            }
        return PREPARED | NO_JOIN;
    }

    @Override
    public void commit(long id, Serializable o) {
    }

    @Override
    public void abort(long id, Serializable o) {
    }
}
