package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.AssertTrue;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {



    List<Note> findAllByTitle(String title);
}
