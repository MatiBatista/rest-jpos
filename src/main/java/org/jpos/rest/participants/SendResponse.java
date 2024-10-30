package org.jpos.rest.participants;


import java.io.Serializable;
import org.jpos.transaction.Context;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.TxnSupport;

import static org.jpos.rest.utils.Constants.TXN_RESULT;

public class SendResponse extends TxnSupport implements AbortParticipant {

    @Override
    public int prepare(long id, Serializable context) {
        return PREPARED | READONLY;
    }

    @Override
    public int prepareForAbort(long id, Serializable context) {
        return ABORTED;
    }

    @Override
    public void commit(long id, Serializable context) {
        Context ctx = (Context) context;
        ctx.put(TXN_RESULT, PREPARED);
    }

    @Override
    public void abort(long id, Serializable context) {
        Context ctx = (Context) context;
        ctx.put(TXN_RESULT, ABORTED);
    }

}
