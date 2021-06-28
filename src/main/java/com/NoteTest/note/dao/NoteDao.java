package com.NoteTest.note.dao;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import com.NoteTest.note.dao.exceptions.DAOException;

import java.util.List;
import java.util.Set;

public interface NoteDao {
    public NoteEntity addNote(String noteTitle, String noteText, Set<HashTagEntity> tags) throws DAOException;
    public void removeNote(NoteEntity removeNote) throws DAOException;
    public void updateNote(NoteEntity updatedNote) throws DAOException;
    public NoteEntity getNoteById(Long noteId) throws DAOException;
    public List<NoteEntity> getNotes() throws DAOException;
}
