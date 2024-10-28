package org.jpos.rest.utils;

import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.lang.reflect.Field;

import static org.jpos.rest.utils.Constants.*;

public class RestSupport extends TxnSupport {

    protected Context createContext(String txnName, Object o) {
        LogEvent evt = new LogEvent("RestSupport");
        try {
            Context ctx = new Context();
            ctx.put(TXN_TYPE, txnName);
            ctx.put(SS, "APPSERVER");
            ctx.put(TXN_REQUEST,o);
            return ctx;
        } catch (Exception ex) {
            evt.addMessage(Utils.printException(ex));
        } finally {
            Logger.log(evt);
        }
        return null;
    }

    protected static int queryTxnMgr(Context ctx, long timeout, LogEvent evt) {
        SpaceFactory.getSpace().out("CABAL_REST_APP.TXN", ctx, timeout);
        Integer result = (Integer) ctx.get(TXN_RESULT, timeout);
        return result != null ? result : -1;
    }
}
