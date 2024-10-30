package org.jpos.rest.services.impl;

import org.jpos.rest.Exceptions.CustomExceptions.BadRequestException;
import org.jpos.rest.dtos.Enum.Thales_Response_Status;
import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.rest.dtos.request.CheckCardEligibilityRequestDTO;
import org.jpos.rest.dtos.request.SendOTPRequestDTO;
import org.jpos.rest.dtos.response.CardDigitalizationResponseDTO;
import org.jpos.rest.dtos.response.CheckCardEligibilityResponseDTO;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.utils.RestSupport;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionManager;
import org.jpos.util.LogEvent;
import org.jvnet.hk2.annotations.Service;

import static org.jpos.rest.utils.Constants.*;

@Service
public class ThalesServiceImpl extends RestSupport implements ThalesService {

    long TIMEOUT = 10000L;


    @Override
    public CheckCardEligibilityResponseDTO checkCardEligibility(CheckCardEligibilityRequestDTO checkCardEligibilityRequestDTO) throws Exception {
        LogEvent evt = new LogEvent("CheckCardElegibility");
        Context ctx = createContext(CHECK_CARD_ELIGIBILITY, checkCardEligibilityRequestDTO);
        int result = queryTxnMgr(ctx, TIMEOUT, evt);
        if (TransactionManager.PREPARED == result) {
            //Tenemos que agarrarlo del ctx despues del txmngr
            return new CheckCardEligibilityResponseDTO();
        }else{
            if(ctx.get(REJECTION_REASON)!=null){
                throw new BadRequestException(Thales_Response_Status.valueOf(ctx.get(REJECTION_REASON)));
            }
            throw new Exception();
        }
    }

    @Override
    public CardDigitalizationResponseDTO requestCardDigitization(CardDigitizationRequestDTO cardDigitizationRequestDTO) throws Exception {
        LogEvent evt = new LogEvent("RequestCardDigitization");
        Context ctx = createContext(REQUEST_CARD_DIGITIZATION, cardDigitizationRequestDTO);
        int result = queryTxnMgr(ctx, TIMEOUT, evt);
        if (TransactionManager.PREPARED == result) {
            //Tenemos que agarrarlo del ctx despues del txmngr
            return new CardDigitalizationResponseDTO();
        }else{
            if(ctx.get(REJECTION_REASON)!=null){
                throw new BadRequestException(Thales_Response_Status.valueOf(ctx.get(REJECTION_REASON)));
            }
            throw new Exception();
        }
    }

    @Override
    public void sendOTP(SendOTPRequestDTO sendOTPRequestDTO) throws Exception {
        LogEvent evt = new LogEvent("SendOTP");
        Context ctx = createContext(SEND_OTP, sendOTPRequestDTO);
        int result = queryTxnMgr(ctx, TIMEOUT, evt);
        if (TransactionManager.ABORTED == result) {
            if(ctx.get(REJECTION_REASON)!=null){
                throw new BadRequestException(Thales_Response_Status.valueOf(ctx.get(REJECTION_REASON)));
            }
            throw new Exception();
        }
    }
}
