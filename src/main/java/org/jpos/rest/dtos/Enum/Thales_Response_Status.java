package org.jpos.rest.dtos.Enum;

public enum Thales_Response_Status {
    MISSING_MANDATORY_PARAMETER(111,"Missing mandatory parameter"),
    BAD_PARAMETER_FORMAT(112,"Bad parameter format"),
    INVALID_CARD_DETAILS(116,"Invalid card details (either FPAN or expiry date)"),
    CARD_EXPIRED_OR_WRONG_EXPIRY(158,"Card is expired or wrong expiry date provided"),
    CARD_SUSPENDED(159,"Card is suspended"),
    CARD_REVOKED_OR_DELETED(160,"Card is revoked or deleted"),
    PRODUCT_NOT_SUPPORTED_FOR_TOKENIZATION(163,"Product not supported for tokenization"),
    FRAUD_SUSPECTED(164,"Fraud Suspected"),
    FRAN_NOT_WHITELISTED(165,"FPAN is not whitelisted for the token requestor. It applies ONLY to American Express"),
    INVALID_FPAN(166,"Invalid FPAN"),
    INVALID_METHOD_ID(501,"Invalid method ID"),
    COMMUNICATION_CHANNEL_NOT_AVAILABLE(502,"Communication channel not available"),
    METHOD_ID_NOT_VALID_ANYMORE(503,"Method ID is not valid anymore"),
    OPERATION_FAILED(911,"Operation failed"),
    UNEXPECTED_SERVER_ERROR(921,"Unexpected server error");

    private final Integer code;
    private final String message;

    Thales_Response_Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}



