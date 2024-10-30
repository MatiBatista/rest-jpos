package org.jpos.rest.participants;

import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;

import java.io.Serializable;

public class Prueba extends TxnSupport {

    private String groupName;

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
        this.groupName=cfg.get("group-name","DEFAULT");
    }


    @Override
    public int prepare(long id, Serializable o) {
        Context ctx = (Context) o;
       info("ESTO ES UNA PRUEBA PARA EL FLUJO " + groupName);
        return PREPARED | NO_JOIN;
    }

    @Override
    public void commit(long id, Serializable o) {
    }

    @Override
    public void abort(long id, Serializable o) {
    }
}
