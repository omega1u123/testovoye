package org.example.oldSystem.models;

public class ClientModel {

    public String agency;
    public String guid;
    public String firstName;
    public String lastName;
    public String status;
    public String dob;
    public String createdDateTime;

    public ClientModel(String agency, String guid, String firstName, String lastName, String status, String dob, String createdDateTime) {
        this.agency = agency;
        this.guid = guid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.dob = dob;
        this.createdDateTime = createdDateTime;
    }
}
