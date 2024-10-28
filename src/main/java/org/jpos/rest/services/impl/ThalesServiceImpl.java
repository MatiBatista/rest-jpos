package org.jpos.rest.services.impl;

import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.utils.RestSupport;
import org.jpos.transaction.Context;
import org.jpos.util.LogEvent;
import org.jvnet.hk2.annotations.Service;

@Service
public class ThalesServiceImpl extends RestSupport implements ThalesService {

    long TIMEOUT=20000L;

    @Override
    public void requestCardDigitization(CardDigitizationRequestDTO cardDigitizationRequestDTO) {
        LogEvent evt = new LogEvent("CheckCardElegibility");
        Context ctx = createContext("check_card_eligibility", cardDigitizationRequestDTO);
        info("Log desde el service");
        int result = queryTxnMgr(ctx, TIMEOUT, evt);
    }
}
