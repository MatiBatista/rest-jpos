package org.jpos.rest.dtos.response;




public class CheckCardEligibilityResponseDTO {

    private String issuerCardRefId;
    private String productId;
    private AccountMetadata accountMetadata;

    // Getters y Setters

    public String getIssuerCardRefId() {
        return issuerCardRefId;
    }

    public void setIssuerCardRefId(String issuerCardRefId) {
        this.issuerCardRefId = issuerCardRefId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public AccountMetadata getAccountMetadata() {
        return accountMetadata;
    }

    public void setAccountMetadata(AccountMetadata accountMetadata) {
        this.accountMetadata = accountMetadata;
    }

    // Clase interna para AccountMetadata
    public static class AccountMetadata {


        private String displayAccountNumber;
        private String expiryDate;

        // Getters y Setters

        public String getDisplayAccountNumber() {
            return displayAccountNumber;
        }

        public void setDisplayAccountNumber(String displayAccountNumber) {
            this.displayAccountNumber = displayAccountNumber;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }
    }
}
