package org.jpos.rest.dtos.request;



import java.util.List;


public class CardDigitizationRequestDTO {

    private String cipheredCardInfo;
    private String issuerCardRefId;
    private String walletProviderId;
    private TokenRequestor tokenRequestor;
    private String walletCardRefId;
    private String authenticationValue;
    private String publicKeyIdentifier;
    private WalletUserInformation walletUserInformation;
    private CardCaptureInformation cardCaptureInformation;
    private ScoringInformation scoringInformation;
    private DeviceInformation deviceInformation;
    private boolean tncStatus;
    private String tncAcceptedDate;
    private boolean cvvValidated;
    private String tokenType;




    //Getters/Setters propios
    public String getCipheredCardInfo() {
        return cipheredCardInfo;
    }

    public void setCipheredCardInfo(String cipheredCardInfo) {
        this.cipheredCardInfo = cipheredCardInfo;
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

    public String getWalletCardRefId() {
        return walletCardRefId;
    }

    public void setWalletCardRefId(String walletCardRefId) {
        this.walletCardRefId = walletCardRefId;
    }

    public String getAuthenticationValue() {
        return authenticationValue;
    }

    public void setAuthenticationValue(String authenticationValue) {
        this.authenticationValue = authenticationValue;
    }

    public String getPublicKeyIdentifier() {
        return publicKeyIdentifier;
    }

    public void setPublicKeyIdentifier(String publicKeyIdentifier) {
        this.publicKeyIdentifier = publicKeyIdentifier;
    }

    public WalletUserInformation getWalletUserInformation() {
        return walletUserInformation;
    }

    public void setWalletUserInformation(WalletUserInformation walletUserInformation) {
        this.walletUserInformation = walletUserInformation;
    }

    public ScoringInformation getScoringInformation() {
        return scoringInformation;
    }

    public void setScoringInformation(ScoringInformation scoringInformation) {
        this.scoringInformation = scoringInformation;
    }

    public CardCaptureInformation getCardCaptureInformation() {
        return cardCaptureInformation;
    }

    public void setCardCaptureInformation(CardCaptureInformation cardCaptureInformation) {
        this.cardCaptureInformation = cardCaptureInformation;
    }

    public DeviceInformation getDeviceInformation() {
        return deviceInformation;
    }

    public void setDeviceInformation(DeviceInformation deviceInformation) {
        this.deviceInformation = deviceInformation;
    }

    public boolean isTncStatus() {
        return tncStatus;
    }

    public void setTncStatus(boolean tncStatus) {
        this.tncStatus = tncStatus;
    }

    public String getTncAcceptedDate() {
        return tncAcceptedDate;
    }

    public void setTncAcceptedDate(String tncAcceptedDate) {
        this.tncAcceptedDate = tncAcceptedDate;
    }

    public boolean isCvvValidated() {
        return cvvValidated;
    }

    public void setCvvValidated(boolean cvvValidated) {
        this.cvvValidated = cvvValidated;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }



    public static class TokenRequestor {
        private String id;
        private String originalTokenRequestorId;
        private String walletId;
        private String merchantId;
        private String name;
        private String tspId;

        // Getters
        public String getId() {
            return id;
        }

        public String getOriginalTokenRequestorId() {
            return originalTokenRequestorId;
        }

        public String getWalletId() {
            return walletId;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public String getName() {
            return name;
        }

        public String getTspId() {
            return tspId;
        }

        // Setters
        public void setId(String id) {
            this.id = id;
        }

        public void setOriginalTokenRequestorId(String originalTokenRequestorId) {
            this.originalTokenRequestorId = originalTokenRequestorId;
        }

        public void setWalletId(String walletId) {
            this.walletId = walletId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTspId(String tspId) {
            this.tspId = tspId;
        }
    }


    public static class WalletUserInformation {
        private String walletUserId;
        private String emailHash;
        private String maskedEmail;
        private boolean isAccountUsernamMatchCardName;
        private String provisioningAttemptsOnDeviceIn24Hours;
        private String walletDistinctCardholderNames;
        private String walletAccountCountry;
        private String suspendedCardsInAccount;
        private String daysSinceLastAccountActivity;
        private String numberOfActiveTokens;
        private String deviceWithActiveTokens;
        private String activeTokensOnAllDeviceForAccount;
        private String daysSinceConsumerDataLastAccountChange;
        private String numberOfTransactionsInLast12Months;
        private String accountEmailLife;

        // Getters
        public String getWalletUserId() {
            return walletUserId;
        }

        public String getEmailHash() {
            return emailHash;
        }

        public String getMaskedEmail() {
            return maskedEmail;
        }

        public boolean isAccountUsernamMatchCardName() {
            return isAccountUsernamMatchCardName;
        }

        public String getProvisioningAttemptsOnDeviceIn24Hours() {
            return provisioningAttemptsOnDeviceIn24Hours;
        }

        public String getWalletDistinctCardholderNames() {
            return walletDistinctCardholderNames;
        }

        public String getWalletAccountCountry() {
            return walletAccountCountry;
        }

        public String getSuspendedCardsInAccount() {
            return suspendedCardsInAccount;
        }

        public String getDaysSinceLastAccountActivity() {
            return daysSinceLastAccountActivity;
        }

        public String getNumberOfActiveTokens() {
            return numberOfActiveTokens;
        }

        public String getDeviceWithActiveTokens() {
            return deviceWithActiveTokens;
        }

        public String getActiveTokensOnAllDeviceForAccount() {
            return activeTokensOnAllDeviceForAccount;
        }

        public String getDaysSinceConsumerDataLastAccountChange() {
            return daysSinceConsumerDataLastAccountChange;
        }

        public String getNumberOfTransactionsInLast12Months() {
            return numberOfTransactionsInLast12Months;
        }

        public String getAccountEmailLife() {
            return accountEmailLife;
        }

        // Setters
        public void setWalletUserId(String walletUserId) {
            this.walletUserId = walletUserId;
        }

        public void setEmailHash(String emailHash) {
            this.emailHash = emailHash;
        }

        public void setMaskedEmail(String maskedEmail) {
            this.maskedEmail = maskedEmail;
        }

        public void setAccountUsernamMatchCardName(boolean accountUsernamMatchCardName) {
            isAccountUsernamMatchCardName = accountUsernamMatchCardName;
        }

        public void setProvisioningAttemptsOnDeviceIn24Hours(String provisioningAttemptsOnDeviceIn24Hours) {
            this.provisioningAttemptsOnDeviceIn24Hours = provisioningAttemptsOnDeviceIn24Hours;
        }

        public void setWalletDistinctCardholderNames(String walletDistinctCardholderNames) {
            this.walletDistinctCardholderNames = walletDistinctCardholderNames;
        }

        public void setWalletAccountCountry(String walletAccountCountry) {
            this.walletAccountCountry = walletAccountCountry;
        }

        public void setSuspendedCardsInAccount(String suspendedCardsInAccount) {
            this.suspendedCardsInAccount = suspendedCardsInAccount;
        }

        public void setDaysSinceLastAccountActivity(String daysSinceLastAccountActivity) {
            this.daysSinceLastAccountActivity = daysSinceLastAccountActivity;
        }

        public void setNumberOfActiveTokens(String numberOfActiveTokens) {
            this.numberOfActiveTokens = numberOfActiveTokens;
        }

        public void setDeviceWithActiveTokens(String deviceWithActiveTokens) {
            this.deviceWithActiveTokens = deviceWithActiveTokens;
        }

        public void setActiveTokensOnAllDeviceForAccount(String activeTokensOnAllDeviceForAccount) {
            this.activeTokensOnAllDeviceForAccount = activeTokensOnAllDeviceForAccount;
        }

        public void setDaysSinceConsumerDataLastAccountChange(String daysSinceConsumerDataLastAccountChange) {
            this.daysSinceConsumerDataLastAccountChange = daysSinceConsumerDataLastAccountChange;
        }

        public void setNumberOfTransactionsInLast12Months(String numberOfTransactionsInLast12Months) {
            this.numberOfTransactionsInLast12Months = numberOfTransactionsInLast12Months;
        }

        public void setAccountEmailLife(String accountEmailLife) {
            this.accountEmailLife = accountEmailLife;
        }
    }


    public static class CardCaptureInformation {
        private String cardHolderName;
        private String captureMethod;
        private String deviceLocation;
        private String sourceIp;
        private Address address;
        private String cardHolderIdType;
        private String cardHolderIdNo;

        public String getCardHolderName() {
            return cardHolderName;
        }

        public void setCardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
        }

        public String getCaptureMethod() {
            return captureMethod;
        }

        public void setCaptureMethod(String captureMethod) {
            this.captureMethod = captureMethod;
        }

        public String getDeviceLocation() {
            return deviceLocation;
        }

        public void setDeviceLocation(String deviceLocation) {
            this.deviceLocation = deviceLocation;
        }

        public String getSourceIp() {
            return sourceIp;
        }

        public void setSourceIp(String sourceIp) {
            this.sourceIp = sourceIp;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getCardHolderIdType() {
            return cardHolderIdType;
        }

        public void setCardHolderIdType(String cardHolderIdType) {
            this.cardHolderIdType = cardHolderIdType;
        }

        public String getCardHolderIdNo() {
            return cardHolderIdNo;
        }

        public void setCardHolderIdNo(String cardHolderIdNo) {
            this.cardHolderIdNo = cardHolderIdNo;
        }

        public static class Address {
            private String addressStreetOne;
            private String addressStreetTwo;
            private String addressCity;
            private String addressState;
            private String addressZip;
            private String addressCountry;


            public String getAddressStreetOne() {
                return addressStreetOne;
            }

            public void setAddressStreetOne(String addressStreetOne) {
                this.addressStreetOne = addressStreetOne;
            }

            public String getAddressStreetTwo() {
                return addressStreetTwo;
            }

            public void setAddressStreetTwo(String addressStreetTwo) {
                this.addressStreetTwo = addressStreetTwo;
            }

            public String getAddressCity() {
                return addressCity;
            }

            public void setAddressCity(String addressCity) {
                this.addressCity = addressCity;
            }

            public String getAddressState() {
                return addressState;
            }

            public void setAddressState(String addressState) {
                this.addressState = addressState;
            }

            public String getAddressZip() {
                return addressZip;
            }

            public void setAddressZip(String addressZip) {
                this.addressZip = addressZip;
            }

            public String getAddressCountry() {
                return addressCountry;
            }

            public void setAddressCountry(String addressCountry) {
                this.addressCountry = addressCountry;
            }
        }
    }


    public static class ScoringInformation {
        private String levelOfTrust;
        private String tspScore;
        private List<String> reasonCodes;
        private String deviceScore;
        private String deviceTenure;
        private String deviceTokens;
        private String deviceCountry;
        private String devicePayJoinDate;
        private String accountScore;
        private String accountCreationDate;
        private String accountLastUpdateDate;
        private String userTenure;
        private String userTokens;
        private String userWallets;
        private String userCountry;
        private String userPayJoinDate;
        private String phoneNumberScore;
        private String walletScore;
        private String walletTenure;
        private String walletTransactions;
        private String cardScore;
        private String cardTenure;
        private boolean cardNewlyAdded;
        private String levelOfTrustStandardVersion;

        // Getters and Setters

        public String getLevelOfTrust() {
            return levelOfTrust;
        }

        public void setLevelOfTrust(String levelOfTrust) {
            this.levelOfTrust = levelOfTrust;
        }

        public String getTspScore() {
            return tspScore;
        }

        public void setTspScore(String tspScore) {
            this.tspScore = tspScore;
        }

        public List<String> getReasonCodes() {
            return reasonCodes;
        }

        public void setReasonCodes(List<String> reasonCodes) {
            this.reasonCodes = reasonCodes;
        }

        public String getDeviceScore() {
            return deviceScore;
        }

        public void setDeviceScore(String deviceScore) {
            this.deviceScore = deviceScore;
        }

        public String getDeviceTenure() {
            return deviceTenure;
        }

        public void setDeviceTenure(String deviceTenure) {
            this.deviceTenure = deviceTenure;
        }

        public String getDeviceTokens() {
            return deviceTokens;
        }

        public void setDeviceTokens(String deviceTokens) {
            this.deviceTokens = deviceTokens;
        }

        public String getDeviceCountry() {
            return deviceCountry;
        }

        public void setDeviceCountry(String deviceCountry) {
            this.deviceCountry = deviceCountry;
        }

        public String getDevicePayJoinDate() {
            return devicePayJoinDate;
        }

        public void setDevicePayJoinDate(String devicePayJoinDate) {
            this.devicePayJoinDate = devicePayJoinDate;
        }

        public String getAccountScore() {
            return accountScore;
        }

        public void setAccountScore(String accountScore) {
            this.accountScore = accountScore;
        }

        public String getAccountCreationDate() {
            return accountCreationDate;
        }

        public void setAccountCreationDate(String accountCreationDate) {
            this.accountCreationDate = accountCreationDate;
        }

        public String getAccountLastUpdateDate() {
            return accountLastUpdateDate;
        }

        public void setAccountLastUpdateDate(String accountLastUpdateDate) {
            this.accountLastUpdateDate = accountLastUpdateDate;
        }

        public String getUserTenure() {
            return userTenure;
        }

        public void setUserTenure(String userTenure) {
            this.userTenure = userTenure;
        }

        public String getUserTokens() {
            return userTokens;
        }

        public void setUserTokens(String userTokens) {
            this.userTokens = userTokens;
        }

        public String getUserWallets() {
            return userWallets;
        }

        public void setUserWallets(String userWallets) {
            this.userWallets = userWallets;
        }

        public String getUserCountry() {
            return userCountry;
        }

        public void setUserCountry(String userCountry) {
            this.userCountry = userCountry;
        }

        public String getUserPayJoinDate() {
            return userPayJoinDate;
        }

        public void setUserPayJoinDate(String userPayJoinDate) {
            this.userPayJoinDate = userPayJoinDate;
        }

        public String getPhoneNumberScore() {
            return phoneNumberScore;
        }

        public void setPhoneNumberScore(String phoneNumberScore) {
            this.phoneNumberScore = phoneNumberScore;
        }

        public String getWalletScore() {
            return walletScore;
        }

        public void setWalletScore(String walletScore) {
            this.walletScore = walletScore;
        }

        public String getWalletTenure() {
            return walletTenure;
        }

        public void setWalletTenure(String walletTenure) {
            this.walletTenure = walletTenure;
        }

        public String getWalletTransactions() {
            return walletTransactions;
        }

        public void setWalletTransactions(String walletTransactions) {
            this.walletTransactions = walletTransactions;
        }

        public String getCardScore() {
            return cardScore;
        }

        public void setCardScore(String cardScore) {
            this.cardScore = cardScore;
        }

        public String getCardTenure() {
            return cardTenure;
        }

        public void setCardTenure(String cardTenure) {
            this.cardTenure = cardTenure;
        }

        public boolean isCardNewlyAdded() {
            return cardNewlyAdded;
        }

        public void setCardNewlyAdded(boolean cardNewlyAdded) {
            this.cardNewlyAdded = cardNewlyAdded;
        }

        public String getLevelOfTrustStandardVersion() {
            return levelOfTrustStandardVersion;
        }

        public void setLevelOfTrustStandardVersion(String levelOfTrustStandardVersion) {
            this.levelOfTrustStandardVersion = levelOfTrustStandardVersion;
        }
    }


    public static class DeviceInformation {
        private String tokenStorageId;
        private String tokenStorageType;
        private String manufacturer;
        private String brand;
        private String model;
        private String tac;
        private String osVersion;
        private String firmwareVersion;
        private String phoneNumber;
        private String fourLastDigitPhoneNumber;
        private String deviceName;
        private String deviceId;
        private String androidIdLastTwo;
        private String deviceParentId;
        private String language;
        private String deviceStateFlags;
        private String serialNumber;
        private String timeZone;
        private String timeZoneSetting;
        private String simSerialNumber;
        private String IMEI;
        private String phoneLostTime;
        private String networkOperator;
        private String networkType;
        private String platform;


        // Getters and Setters

        public String getTokenStorageId() {
            return tokenStorageId;
        }

        public void setTokenStorageId(String tokenStorageId) {
            this.tokenStorageId = tokenStorageId;
        }

        public String getTokenStorageType() {
            return tokenStorageType;
        }

        public void setTokenStorageType(String tokenStorageType) {
            this.tokenStorageType = tokenStorageType;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getTac() {
            return tac;
        }

        public void setTac(String tac) {
            this.tac = tac;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public String getFirmwareVersion() {
            return firmwareVersion;
        }

        public void setFirmwareVersion(String firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getFourLastDigitPhoneNumber() {
            return fourLastDigitPhoneNumber;
        }

        public void setFourLastDigitPhoneNumber(String fourLastDigitPhoneNumber) {
            this.fourLastDigitPhoneNumber = fourLastDigitPhoneNumber;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getAndroidIdLastTwo() {
            return androidIdLastTwo;
        }

        public void setAndroidIdLastTwo(String androidIdLastTwo) {
            this.androidIdLastTwo = androidIdLastTwo;
        }

        public String getDeviceParentId() {
            return deviceParentId;
        }

        public void setDeviceParentId(String deviceParentId) {
            this.deviceParentId = deviceParentId;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getDeviceStateFlags() {
            return deviceStateFlags;
        }

        public void setDeviceStateFlags(String deviceStateFlags) {
            this.deviceStateFlags = deviceStateFlags;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getTimeZone() {
            return timeZone;
        }

        public void setTimeZone(String timeZone) {
            this.timeZone = timeZone;
        }

        public String getTimeZoneSetting() {
            return timeZoneSetting;
        }

        public void setTimeZoneSetting(String timeZoneSetting) {
            this.timeZoneSetting = timeZoneSetting;
        }

        public String getSimSerialNumber() {
            return simSerialNumber;
        }

        public void setSimSerialNumber(String simSerialNumber) {
            this.simSerialNumber = simSerialNumber;
        }

        public String getIMEI() {
            return IMEI;
        }

        public void setIMEI(String IMEI) {
            this.IMEI = IMEI;
        }

        public String getPhoneLostTime() {
            return phoneLostTime;
        }

        public void setPhoneLostTime(String phoneLostTime) {
            this.phoneLostTime = phoneLostTime;
        }

        public String getNetworkOperator() {
            return networkOperator;
        }

        public void setNetworkOperator(String networkOperator) {
            this.networkOperator = networkOperator;
        }

        public String getNetworkType() {
            return networkType;
        }

        public void setNetworkType(String networkType) {
            this.networkType = networkType;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }
    }
}


