package org.jpos.rest.dtos.request;

public class SendOTPRequestDTO {

    private String walletProviderId;
    private TokenRequestor tokenRequestor;
    private String issuerCardRefId;
    private String deviceBindingReference;
    private String otpValue;
    private String expirationDate;
    private String otpMethodId;

    public SendOTPRequestDTO(String walletProviderId, TokenRequestor tokenRequestor, String issuerCardRefId, String deviceBindingReference, String otpValue, String expirationDate, String otpMethodId) {
        this.walletProviderId = walletProviderId;
        this.tokenRequestor = tokenRequestor;
        this.issuerCardRefId = issuerCardRefId;
        this.deviceBindingReference = deviceBindingReference;
        this.otpValue = otpValue;
        this.expirationDate = expirationDate;
        this.otpMethodId = otpMethodId;
    }

    public SendOTPRequestDTO() {
    }
    // Getters and Setters

    public String getWalletProviderId() {
        return walletProviderId;
    }

    public void setWalletProviderId(String walletProviderId) {
        this.walletProviderId = walletProviderId;
    }

    public TokenRequestor getTokenRequestor() {
        return tokenRequestor;
    }

    public void setTokenRequestor(TokenRequestor tokenRequestor) {
        this.tokenRequestor = tokenRequestor;
    }

    public String getIssuerCardRefId() {
        return issuerCardRefId;
    }

    public void setIssuerCardRefId(String issuerCardRefId) {
        this.issuerCardRefId = issuerCardRefId;
    }

    public String getDeviceBindingReference() {
        return deviceBindingReference;
    }

    public void setDeviceBindingReference(String deviceBindingReference) {
        this.deviceBindingReference = deviceBindingReference;
    }

    public String getOtpValue() {
        return otpValue;
    }

    public void setOtpValue(String otpValue) {
        this.otpValue = otpValue;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOtpMethodId() {
        return otpMethodId;
    }

    public void setOtpMethodId(String otpMethodId) {
        this.otpMethodId = otpMethodId;
    }

    // Inner class for TokenRequestor
    public static class TokenRequestor {

        private String id;
        private String originalTokenRequestorId;
        private String walletId;
        private String merchantId;
        private String name;

        // Getters and Setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOriginalTokenRequestorId() {
            return originalTokenRequestorId;
        }

        public void setOriginalTokenRequestorId(String originalTokenRequestorId) {
            this.originalTokenRequestorId = originalTokenRequestorId;
        }

        public String getWalletId() {
            return walletId;
        }

        public void setWalletId(String walletId) {
            this.walletId = walletId;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
