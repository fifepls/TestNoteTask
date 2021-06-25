package com.NoteTest.note.dao.daoimpl;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import com.NoteTest.note.dao.HibernateUtil;
import com.NoteTest.note.dao.NoteDao;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class NoteDaoImpl implements NoteDao {
    @Override
    public Long addNote(String noteTitle, String noteText, Date date, Set<HashTagEntity> tags) {
        NoteEntity noteEntity = new NoteEntity();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        noteEntity.setTitle(noteTitle);
        noteEntity.setNoteText(noteText);
        noteEntity.setTags(tags);
        noteEntity.setCreateDate(date);
        Long savedId =(Long) session.save(noteEntity);
        session.getTransaction().commit();
        session.close();
        return savedId;
    }

    @Override
    public void removeNote(NoteEntity removeNote) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.delete(removeNote);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateNote(NoteEntity updatedNote) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(updatedNote);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<NoteEntity> getNotes() {
        Session session = HibernateUtil.getSession();
        return (List<NoteEntity>) session.createCriteria(NoteEntity.class).list();
    }

    @Override
    public NoteEntity getNoteById(Long noteId) {
        Session session = HibernateUtil.getSession();
        NoteEntity note = (NoteEntity) session.get(NoteEntity.class, noteId);
        session.close();
        return note;
    }
}
