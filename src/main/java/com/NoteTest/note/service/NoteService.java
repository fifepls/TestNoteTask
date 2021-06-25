package com.NoteTest.note.service;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import java.util.List;
import java.util.Set;

public interface NoteService {
    public NoteEntity addNote(String noteTitle, String noteText, Set<HashTagEntity> tags);
    public void removeNote(Long noteId);
    public void updateNote(Long noteId, String noteTitle, String noteText, Set<HashTagEntity> tags);
    public List<NoteEntity> getNotes();
    public List<NoteEntity> getNotesSortByDate();
    public List<NoteEntity> getNotesThatContainsWord(String Word);
    public List<NoteEntity> getNotesSortByTags(Set<Long> tagNames);


}
