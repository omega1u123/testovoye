package org.example.oldSystem.models;

import lombok.ToString;

import java.time.LocalDate;
@ToString
public class Payload {

    public String agency;
    public LocalDate dateFrom;
    public LocalDate dateTo;
    public String clientGuid;
}
