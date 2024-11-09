package org.example.oldSystem;

import org.example.oldSystem.models.ClientModel;
import org.example.oldSystem.models.NotesModel;
import org.example.oldSystem.models.Payload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    @PostMapping("/clients")
    public ResponseEntity<List<ClientModel>> getClients(){
        return ResponseEntity.ok(DataSource.clientData);
    }

    @PostMapping("/notes")
    public ResponseEntity<List<NotesModel>> getNotes(@RequestBody Payload payload){
        var notes = new ArrayList<NotesModel>();
        for(NotesModel n : DataSource.notesData){
            if(n.guid.equals(payload.clientGuid)
                    && n.dateTime.isAfter(payload.dateFrom.atStartOfDay())
                    && n.dateTime.isBefore(payload.dateTo.atStartOfDay())
            )
            {
                notes.add(n);
            }
        }
        return ResponseEntity.ok(notes);
    }

}
