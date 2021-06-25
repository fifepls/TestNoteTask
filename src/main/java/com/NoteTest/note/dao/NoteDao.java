package com.NoteTest.note.dao;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;

import java.util.List;

public interface NoteDao {
    public void addNote(String noteTitle, String noteText, List<HashTagEntity> tags);
    public void removeNote(Long noteId);
    public void updateNote(Long noteId, String noteTitle, String noteText, List<HashTagEntity> tags);
    public List<NoteEntity> getNotes();


}
