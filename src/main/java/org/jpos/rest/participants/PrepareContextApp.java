package org.jpos.rest.participants;

import java.io.Serializable;
import java.util.Date;

import org.jpos.rest.Exceptions.CustomExceptions.BadRequestException;
import org.jpos.rest.dtos.Enum.Thales_Response_Status;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;

import static org.jpos.rest.utils.Constants.TIMESTAMP;


public class PrepareContextApp extends TxnSupport {

    @Override
    public int prepare(long id, Serializable o) {
        Context ctx = (Context) o;
        ctx.getProfiler();
        if (ctx.get(TIMESTAMP) == null) {
            ctx.put(TIMESTAMP, new Date());
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