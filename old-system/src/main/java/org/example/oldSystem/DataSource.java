package org.example.oldSystem;

import org.example.oldSystem.models.ClientModel;
import org.example.oldSystem.models.NotesModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {

    public static List<ClientModel> clientData = new ArrayList<>(Arrays.asList(
            new ClientModel(
                    "vhh4",
                    "C5DCAA49-ADE5-E65C-B776-3F6D7B5F2055",
                    "Ne",
                    "Abr",
                    "INACTIVE",
                    "10-15-1999",
                    "2021-11-15 11:51:59"
            ),
            new ClientModel(
                    "vhh5",
                    "D1E2F3G4-H5I6-J7K8-L9M0-N1O2P3Q4R5S6",
                    "An",
                    "Zar",
                    "ACTIVE",
                    "03-22-1995",
                    "2022-01-10 09:30:45"
            ),
            new ClientModel(
                    "vhh6",
                    "E2F3G4H5-I6J7-K8L9-M0N1-O2P3Q4R5S6T7",
                    "Li",
                    "Kum",
                    "INACTIVE",
                    "07-05-1988",
                    "2023-02-20 14:15:30"
            ),
            new ClientModel(
                    "vhh7",
                    "F3G4H5I6-J7K8-L9M0-N1O2-P3Q4R5S6T8U9",
                    "Ra",
                    "Tan",
                    "ACTIVE",
                    "12-01-1992",
                    "2021-08-25 16:45:12"
            ),
            new ClientModel(
                    "vhh8",
                    "G4H5I6J7-K8L9-M0N1-O2P3-Q4R5S6T8U0V1",
                    "Si",
                    "Lee",
                    "INACTIVE",
                    "11-30-1990",
                    "2020-03-15 10:00:00"
            ),
            new ClientModel(
                    "vhh9",
                    "H5I6J7K8-L9M0-N1O2-P3Q4-R5S6T8U1V2W3",
                    "Mi",
                    "Cho",
                    "ACTIVE",
                    "05-18-1996",
                    "2021-06-05 13:25:50"
            )
    ));

    public static List<NotesModel> notesData = new ArrayList<>(Arrays.asList(
            new NotesModel(
                    "Patient Care Coordinator, reached out to patient caregiver is still in the hospital.",
                    "C5DCAA49-ADE5-E65C-B776-3F6D7B5F2055",
                    "2021-11-15 11:51:59",
                    "C5DCAA49-ADE5-E65C-B776-3F6D7B5F2055",
                    LocalDateTime.of(2021, 9, 16, 12, 2, 26),
                    "p.vasya",
                    "2021-11-15 11:51:59"
            ),
            new NotesModel(
                    "Nurse Practitioner, updated patient status; recovery is progressing well.",
                    "D1E2F3G4-H5I6-J7K8-L9M0-N1O2P3Q4R5S6",
                    "2022-01-10 09:30:45",
                    "D1E2F3G4-H5I6-J7K8-L9M0-N1O2P3Q4R5S6",
                    LocalDateTime.of(2021, 9, 17, 14, 15, 30),
                    "j.doe",
                    "2022-01-10 09:30:45"
            ),
            new NotesModel(
                    "Social Worker, discussed discharge plans with family; follow-up scheduled.",
                    "E2F3G4H5-I6J7-K8L9-M0N1-O2P3Q4R5S6T7",
                    "2023-02-20 14:15:30",
                    "E2F3G4H5-I6J7-K8L9-M0N1-O2P3Q4R5S6T7",
                    LocalDateTime.of(2021, 9, 18, 10, 0, 0),
                    "m.smith",
                    "2023-02-20 14:15:30"
            ),
            new NotesModel(
                    "Physician, reviewed lab results; medication adjusted accordingly.",
                    "F3G4H5I6-J7K8-L9M0-N1O2-P3Q4R5S6T8U9",
                    "2021-08-25 16:45:12",
                    "F3G4H5I6-J7K8-L9M0-N1O2-P3Q4R5S6T8U9",
                    LocalDateTime.of(2021, 9, 19, 11, 30, 0),
                    "a.johnson",
                    "2021-08-25 16:45:12"
            ),
            new NotesModel(
                    "Physical Therapist, conducted evaluation; patient shows good mobility.",
                    "G4H5I6J7-K8L9-M0N1-O2P3-Q4R5S6T8U0V1",
                    "2020-03-15 10:00:00",
                    "G4H5I6J7-K8L9-M0N1-O2P3-Q4R5S6T8U0V1",
                    LocalDateTime.of(2021, 9, 20, 9, 45, 0),
                    "l.brown",
                    "2020-03-15 10:00:00"
            ),
            new NotesModel(
                    "Dietitian, provided nutritional guidance to patient; follow-up in one week.",
                    "H5I6J7K8-L9M0-N1O2-P3Q4-R5S6T8U1V2W3",
                    "2021-06-05 13:25:50",
                    "H5I6J7K8-L9M0-N1O2-P3Q4-R5S6T8U1V2W3",
                    LocalDateTime.of(2021, 9, 21, 15, 0, 0),
                    "t.wilson",
                    "2021-06-05 13:25:50"
            )
    ));

}
