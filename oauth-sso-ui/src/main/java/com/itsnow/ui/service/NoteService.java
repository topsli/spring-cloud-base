package com.itsnow.ui.service;



import com.itsnow.ui.dto.NoteDTO;

import java.util.Collection;

public interface NoteService {
    Collection<NoteDTO> getAllNotes();
    NoteDTO addNote(NoteDTO note);
}
