package com.digitalharbor.hospital.service;

import com.digitalharbor.hospital.model.Notes;
import com.digitalharbor.hospital.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    NotesRepository notesRepository;

    @Override
    public List<Notes> findAllNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Optional<Notes> findNotesById(Long id) {
        Optional<Notes> notes = notesRepository.findById(id);
        return notes;
    }

    @Override
    public Notes saveNotes(Notes notesNew) {
        if(notesNew != null) {
            return notesRepository.save(notesNew);
        }
        return new Notes();
    }

    @Override
    public String deleteNotes(Long id) {
        if(notesRepository.findById(id).isPresent()){
            notesRepository.deleteById(id);
            return "Notes has been deleted";
        }
        return "Error! The notes does not exist";
    }

    @Override
    public String updateNotes(Notes notesNew) {
        Long num = notesNew.getId();
        if(notesRepository.findById(num).isPresent()) {
            Notes notesToUpdate = new Notes();
            notesToUpdate.setId(num);
            notesToUpdate.setDescription(notesNew.getDescription());
            notesRepository.save(notesNew);
            return "Notes has been updated";
        }
        return "Error! Cannot update the notes";
    }
}
