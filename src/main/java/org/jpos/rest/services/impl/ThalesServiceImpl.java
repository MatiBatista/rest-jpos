package org.jpos.rest.services.impl;

import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.rest.dtos.request.CheckCardEligibilityRequestDTO;
import org.jpos.rest.dtos.request.SendOTPRequestDTO;
import org.jpos.rest.dtos.response.CardDigitalizationResponseDTO;
import org.jpos.rest.dtos.response.CheckCardEligibilityResponseDTO;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.utils.RestSupport;
import org.jpos.transaction.Context;
import org.jpos.util.LogEvent;
import org.jvnet.hk2.annotations.Service;

import static org.jpos.rest.utils.Constants.*;

@Service
public class ThalesServiceImpl extends RestSupport implements ThalesService {

    long TIMEOUT=1000L;


    @Override
    public CheckCardEligibilityResponseDTO checkCardEligibility(CheckCardEligibilityRequestDTO checkCardEligibilityRequestDTO) {
        LogEvent evt = new LogEvent("CheckCardElegibility");
        Context ctx = createContext(CHECK_CARD_ELIGIBILITY, checkCardEligibilityRequestDTO);
        int result = queryTxnMgr(ctx, TIMEOUT, evt);
        return new CheckCardEligibilityResponseDTO();
    }

    @Override
    public CardDigitalizationResponseDTO requestCardDigitization(CardDigitizationRequestDTO cardDigitizationRequestDTO) {
        LogEvent evt = new LogEvent("RequestCardDigitization");
        Context ctx = createContext(REQUEST_CARD_DIGITIZATION, cardDigitizationRequestDTO);
        int result = queryTxnMgr(ctx, TIMEOUT, evt);
        return new CardDigitalizationResponseDTO();
    }

    @Override
    public void sendOTP(SendOTPRequestDTO sendOTPRequestDTO) {
        LogEvent evt = new LogEvent("SendOTP");
        Context ctx = createContext(SEND_OTP, sendOTPRequestDTO);
        int result = queryTxnMgr(ctx, TIMEOUT, evt);
    }
}
