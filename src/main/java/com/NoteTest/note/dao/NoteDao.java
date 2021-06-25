package com.NoteTest.note.dao;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;

import java.util.List;
import java.util.Set;

public interface NoteDao {
    public NoteEntity addNote(String noteTitle, String noteText, Set<HashTagEntity> tags);
    public void removeNote(NoteEntity removeNote);
    public void updateNote(NoteEntity updatedNote);
    public NoteEntity getNoteById(Long noteId);
    public List<NoteEntity> getNotes();
}
