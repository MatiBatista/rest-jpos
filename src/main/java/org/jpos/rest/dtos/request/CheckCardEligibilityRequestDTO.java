package org.jpos.rest.dtos.request;

public class CheckCardEligibilityRequestDTO {
    private String cipheredCardInfo;
    private String publicKeyIdentifier;
    private String issuerCardRefId;
    private String walletProviderId;
    private TokenRequestor tokenRequestor;
    private String captureMethod;

    // Getters and Setters

    public String getCipheredCardInfo() {
        return cipheredCardInfo;
    }

    public void setCipheredCardInfo(String cipheredCardInfo) {
        this.cipheredCardInfo = cipheredCardInfo;
    }

    public String getPublicKeyIdentifier() {
        return publicKeyIdentifier;
    }

    public void setPublicKeyIdentifier(String publicKeyIdentifier) {
        this.publicKeyIdentifier = publicKeyIdentifier;
    }

    public String getIssuerCardRefId() {
        return issuerCardRefId;
    }

    public void setIssuerCardRefId(String issuerCardRefId) {
        this.issuerCardRefId = issuerCardRefId;
    }

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

    public String getCaptureMethod() {
        return captureMethod;
    }

    public void setCaptureMethod(String captureMethod) {
        this.captureMethod = captureMethod;
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
