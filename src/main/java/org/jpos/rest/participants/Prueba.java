package org.jpos.rest.participants;

import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;

import java.io.Serializable;

public class Prueba extends TxnSupport {


    @Override
    public int prepare(long id, Serializable o) {
        Context ctx = (Context) o;
       info("ESTO ES UNA PRUEBA");
        return PREPARED | NO_JOIN;
    }

    @Override
    public void commit(long id, Serializable o) {
    }

    @Override
    public void abort(long id, Serializable o) {
    }
}
