package com.stackoverflow.q47245185;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class ServicePayload implements Serializable {

    private static final long serialVersionUID = 1L;

    public ServicePayload(){}

    public ServicePayload(String chances, String plainOutput, String email, String display, String fromLocal) {
        this.chances = chances;
        this.plainOutput = plainOutput;
        this.email = email;
        this.display = display;
        this.fromSystem = fromLocal;
    }

    @JsonProperty("Chances")
    private String chances;

    @JsonProperty("PlainOutput")
    private String plainOutput;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Display")
    private String display;

    @JsonProperty("FromSystem")
    private String fromSystem;

    @Override
    public String toString() {
        return "ServicePayload{" +
                "chances='" + chances + '\'' +
                ", plainOutput='" + plainOutput + '\'' +
                ", email='" + email + '\'' +
                ", display='" + display + '\'' +
                ", fromSystem='" + fromSystem + '\'' +
                '}';
    }
}

