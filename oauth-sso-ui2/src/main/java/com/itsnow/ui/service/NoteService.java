package com.itsnow.ui.service;



import com.itsnow.ui.dto.NoteDTO;

import java.util.Collection;

/**
 * Created by jjmendoza on 18/7/2017.
 */
public interface NoteService {
    Collection<NoteDTO> getAllNotes();
    NoteDTO addNote(NoteDTO note);
}
