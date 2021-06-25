package com.NoteTest.note.service.serviceImpl;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import com.NoteTest.note.dao.HashTagDao;
import com.NoteTest.note.dao.NoteDao;
import com.NoteTest.note.service.NoteService;
import com.NoteTest.note.util.NoteDateComparator;
import com.NoteTest.note.util.NoteHashTagSorter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;


@Service
public class NoteServiceImpl implements NoteService {
    private final NoteDao noteDao;
    private final NoteDateComparator noteDateComparator;
    private final NoteHashTagSorter noteHashTagSorter;
    private final HashTagDao hashTagDao;

    public NoteServiceImpl(NoteDao noteDao, NoteDateComparator noteDateComparator, NoteHashTagSorter noteHashTagSorter, HashTagDao hashTagDao) {
        this.noteDao = noteDao;
        this.noteDateComparator = noteDateComparator;
        this.noteHashTagSorter = noteHashTagSorter;
        this.hashTagDao = hashTagDao;
    }

    @Override
    public NoteEntity addNote(String noteTitle, String noteText, Set<HashTagEntity> tags) {
        return noteDao.addNote(noteTitle,noteText,tags);
    }

    @Override
    public void removeNote(Long noteId) {
        NoteEntity removeNote = noteDao.getNoteById(noteId);
        if(removeNote.getId().equals(noteId)) {//if exists
            noteDao.removeNote(removeNote);
        }
    }

    @Override
    public void updateNote(Long noteId, String noteTitle, String noteText, Set<HashTagEntity> tags) {

        NoteEntity noteForUpdate = noteDao.getNoteById(noteId);

        if(noteForUpdate.getId().equals(noteId)) {//if exists
            noteForUpdate.setNoteText(noteText);
            noteForUpdate.setTitle(noteTitle);
            noteForUpdate.setTags(tags);
            noteDao.updateNote(noteForUpdate);
        }
    }

    @Override
    public List<NoteEntity> getNotesSortByDate() {
        List<NoteEntity> notes = noteDao.getNotes();
        notes.sort(noteDateComparator);
        return notes;
    }

    @Override
    public List<NoteEntity> getNotes() {
        return noteDao.getNotes();
    }

    @Override
    public List<NoteEntity> getNotesThatContainsWord(String word) {
        List<NoteEntity> allNotes = noteDao.getNotes();
        allNotes.removeIf(note -> !(note.getNoteText().contains(word) || note.getTitle().contains(word)));
        return allNotes;
    }

    @Override
    public List<NoteEntity> getNotesSortByTags(Set<Long> tagIds) {
        List<NoteEntity> allNotes = noteDao.getNotes();
        Set<HashTagEntity> hashTagByNames = hashTagDao.getHashTagsByHashTagId(tagIds);
        return noteHashTagSorter.sortNotesByTags(allNotes,hashTagByNames);
    }
}
