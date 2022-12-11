package com.stackoverflow.q47245185;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ServiceResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public ServiceResponse(String status, ServicePayload payload) {
        this.status = status;
        this.payload = payload;
    }

    public ServiceResponse(){}

    private String status;

    @JsonProperty("payload")
    private ServicePayload payload;

    public String getStatus() {
        return status;
    }


    public ServicePayload getPayload() {
        return payload;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayload(ServicePayload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ServicePayload{" +
                "status='" + status + '\'' +
                ", payload=" + payload +
                '}';
    }
}
