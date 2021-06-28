package com.NoteTest.note.service.serviceImpl;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import com.NoteTest.note.dao.HashTagDao;
import com.NoteTest.note.dao.NoteDao;
import com.NoteTest.note.dao.exceptions.DAOException;
import com.NoteTest.note.service.NoteService;
import com.NoteTest.note.util.NoteDateComparator;
import com.NoteTest.note.util.NoteHashTagSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
class NoteServiceImplTest {

    @Autowired
    private NoteService noteService;


    @MockBean
    private NoteDao noteDao;

    @MockBean
    private HashTagEntity hashTagEntity;

    @MockBean
    private NoteDateComparator noteDateComparator;

    @MockBean
    private NoteHashTagSorter noteHashTagSorter;

    @MockBean
    private HashTagDao hashTagDao;

    @Test
    void addNote() throws DAOException {
        String title = "test title";
        String text = "test text";
        Set<HashTagEntity> tags = Set.of(new HashTagEntity("tag1"),new HashTagEntity("tag2"));
        Date date = new Date();

        Mockito.doReturn(new NoteEntity(1L,title,text, date, tags)).when(noteDao).addNote(title,text,tags);

        NoteEntity addedNote = noteService.addNote(title,text,tags);

        Assertions.assertEquals(title,addedNote.getTitle());
        Assertions.assertEquals(text,addedNote.getNoteText());
        Assertions.assertEquals(tags,addedNote.getTags());
        Assertions.assertEquals(1L,addedNote.getId());



    }

    @Test
    void updateNote() throws DAOException {
        Long id = 1L;
        String title = "test title";
        String text = "test text";
        Set<HashTagEntity> tags = Set.of(new HashTagEntity("tag1"),new HashTagEntity("tag2"));
        Date date = new Date();

        Mockito.doReturn(new NoteEntity(id,title,text, date, tags)).when(noteDao).getNoteById(1L);

        noteService.updateNote(1L,"new title","new text",Set.of(new HashTagEntity("new tag"),new HashTagEntity("new tag")));

        Mockito.verify(noteDao,Mockito.times(1)).getNoteById(1L);

        Mockito.verify(noteDao,Mockito.times(1)).updateNote(Mockito.any(NoteEntity.class));

    }

    @Test
    void getNotesSortByDate() throws DAOException {
        noteService.getNotes();
        Mockito.verify(noteDao,Mockito.times(1)).getNotes();
    }

    @Test
    void getNotes() throws DAOException {
        noteService.getNotes();
        Mockito.verify(noteDao,Mockito.times(1)).getNotes();
    }

    @Test
    void getNotesThatContainsWord() throws DAOException {
        Mockito.verify(noteDao,Mockito.times(1)).getNotes();
    }

    @Test
    void getNotesSortByTags() throws DAOException {
        noteService.getNotes();
        Mockito.verify(noteDao,Mockito.times(1)).getNotes();
    }
}