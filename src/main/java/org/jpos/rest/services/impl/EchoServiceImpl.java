package org.jpos.rest.services.impl;


import org.jpos.rest.dtos.response.EchoResponseDTO;
import org.jpos.rest.services.contracts.EchoService;
import org.jpos.rest.utils.RestSupport;
import org.jpos.transaction.Context;
import org.jpos.util.LogEvent;
import org.jvnet.hk2.annotations.Service;

import static org.jpos.rest.utils.Constants.CHECK_CARD_ELIGIBILITY;


@Service
public class EchoServiceImpl extends RestSupport implements EchoService {
    long TIMEOUT = 10000L;

    @Override
    public EchoResponseDTO echo() {
        LogEvent evt = new LogEvent("CheckCardElegibility");
        Context ctx = createContext(CHECK_CARD_ELIGIBILITY, "sadasdasd");
        int result = queryTxnMgr(ctx, TIMEOUT, evt);

        return new EchoResponseDTO("Echo!");
    }

}
