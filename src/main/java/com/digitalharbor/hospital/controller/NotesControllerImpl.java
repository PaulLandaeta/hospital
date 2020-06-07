package com.digitalharbor.hospital.controller;

import com.digitalharbor.hospital.model.Notes;
import com.digitalharbor.hospital.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class NotesControllerImpl implements NotesController {
    @Autowired
    NotesService notesService;

    @RequestMapping(value = "/notes", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Notes> getNotes() {
        return notesService.findAllNotes();
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<Notes> getNotesById(Long id) {
        return notesService.findNotesById(id);
    }

    @RequestMapping(value = "/notes/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public Notes addHospital(Notes notes) {
        return notesService.saveNotes(notes);
    }

    @RequestMapping(value = "/notes/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String deleteNotes(Long id) {
        return notesService.deleteNotes(id);
    }

    @RequestMapping(value = "/notes/update", method = RequestMethod.PATCH, produces = "application/json")
    @Override
    public String updateNotes(Notes notesUpdated) {
        return notesService.updateNotes(notesUpdated);
    }
}
