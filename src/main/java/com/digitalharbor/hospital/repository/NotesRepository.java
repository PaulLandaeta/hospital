package com.digitalharbor.hospital.repository;


import com.digitalharbor.hospital.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotesRepository  extends JpaRepository<Notes, Long> {
    Void save(Optional<Notes> notesToUpdate);

}
