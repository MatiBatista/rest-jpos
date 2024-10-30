package org.jpos.rest.dtos.response;



import java.util.List;


public class CardDigitalizationResponseDTO {
    private String issuerCardRefId;
    private String productId;
    private CardDetails cardDetails;
    private String levelOfTrust;
    private List<IdvMethod> idvMethodList;

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

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public String getLevelOfTrust() {
        return levelOfTrust;
    }

    public void setLevelOfTrust(String levelOfTrust) {
        this.levelOfTrust = levelOfTrust;
    }

    public List<IdvMethod> getIdvMethodList() {
        return idvMethodList;
    }

    public void setIdvMethodList(List<IdvMethod> idvMethodList) {
        this.idvMethodList = idvMethodList;
    }

    // Clase anidada para CardDetails
    public static class CardDetails {


        private String cardholderName;
        private String fpanLastDigits;
        private String fpanBin;
        private String fpanExpiryDate;

        // Getters y Setters

        public String getCardholderName() {
            return cardholderName;
        }

        public void setCardholderName(String cardholderName) {
            this.cardholderName = cardholderName;
        }

        public String getFpanLastDigits() {
            return fpanLastDigits;
        }

        public void setFpanLastDigits(String fpanLastDigits) {
            this.fpanLastDigits = fpanLastDigits;
        }

        public String getFpanBin() {
            return fpanBin;
        }

        public void setFpanBin(String fpanBin) {
            this.fpanBin = fpanBin;
        }

        public String getFpanExpiryDate() {
            return fpanExpiryDate;
        }

        public void setFpanExpiryDate(String fpanExpiryDate) {
            this.fpanExpiryDate = fpanExpiryDate;
        }
    }

    // Clase anidada para IdvMethod
    public static class IdvMethod {


        private String id;
        private String type;
        private String value;

        // Getters y Setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
