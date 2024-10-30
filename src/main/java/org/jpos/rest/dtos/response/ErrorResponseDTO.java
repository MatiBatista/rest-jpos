package org.jpos.rest.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorResponseDTO implements Serializable {

    private Integer responseCode;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;


    public ErrorResponseDTO(Integer responseCode,String message, String status){
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.responseCode =  responseCode;
        this.message = message;
    }

    public ErrorResponseDTO() {
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponseDTO{" +
                "responseCode=" + responseCode +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
