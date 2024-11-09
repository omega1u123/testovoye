package org.example.oldSystem.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotesModel {

    public String comments;
    public String guid;
    public String modifiedDateTime;
    public String clientGuid;
    public LocalDateTime dateTime;
    public String loggedUser;
    public String createdDateTime;

    public NotesModel(String comments, String guid, String modifiedDateTime, String clientGuid, LocalDateTime dateTime, String loggedUser, String createdDateTime) {
        this.comments = comments;
        this.guid = guid;
        this.modifiedDateTime = modifiedDateTime;
        this.clientGuid = clientGuid;
        this.dateTime = dateTime;
        this.loggedUser = loggedUser;
        this.createdDateTime = createdDateTime;
    }
}
