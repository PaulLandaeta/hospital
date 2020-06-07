package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Notes;

import java.util.List;
import java.util.Optional;

public interface NotesController {
    public List<Notes> getNotes();

    public Optional<Notes> getNotesById(Long id);

    public Notes addHospital(Notes notes);

    public String deleteNotes(Long id);

    public String updateNotes(Notes notesUpdated);
}
