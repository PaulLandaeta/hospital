package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Notes;

import java.util.List;
import java.util.Optional;

public interface NotesService {
    public List<Notes> findAllNotes();

    public Optional<Notes> findNotesById(Long id);

    public Notes saveNotes(Notes notesNew);

    public String deleteNotes(Long id);

    public String updateNotes(Notes notesNew);
}
