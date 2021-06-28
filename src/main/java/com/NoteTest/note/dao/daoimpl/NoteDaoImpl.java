package com.NoteTest.note.dao.daoimpl;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import com.NoteTest.note.dao.HibernateUtil;
import com.NoteTest.note.dao.NoteDao;
import com.NoteTest.note.dao.exceptions.DAOException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class NoteDaoImpl implements NoteDao {
    @Override
    public NoteEntity addNote(String noteTitle, String noteText, Set<HashTagEntity> tags) throws DAOException {
        Session session = null;
        try {
            NoteEntity noteEntity = new NoteEntity();
            session = HibernateUtil.getSession();
            session.beginTransaction();
            noteEntity.setTitle(noteTitle);
            noteEntity.setNoteText(noteText);
            noteEntity.setTags(tags);
            noteEntity.setCreateDate(new Date());
            Long savedId = (Long) session.save(noteEntity);
            noteEntity.setId(savedId);
            session.getTransaction().commit();
            return noteEntity;
        }catch (Exception e){
            if(session != null){
                session.getTransaction().rollback();
            }
            throw new DAOException("problem with adding note",e);
        }finally {
            if(session != null)
                session.close();

        }
    }

    @Override
    public void removeNote(NoteEntity removeNote) throws DAOException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            session.delete(removeNote);

            session.getTransaction().commit();
        }catch (Exception e){
            if(session != null) {
                session.getTransaction().rollback();
            }
            throw new DAOException("problem with removing note",e);
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateNote(NoteEntity updatedNote) throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSession();

            session.beginTransaction();
            session.update(updatedNote);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session != null){
                session.getTransaction().rollback();
            }
            throw  new DAOException("problem with updating note",e );
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<NoteEntity> getNotes() throws DAOException {
        Session session = null;
        try{
            session =  HibernateUtil.getSession();
            List<NoteEntity> notes = (List<NoteEntity>) session.createCriteria(NoteEntity.class).list();
            if(notes != null){
                return notes;
            }
            return Collections.emptyList();
        }catch (Exception e){
            throw new DAOException("failed not get al notes",e);
        }finally {
            if(session != null){
                session.close();
            }
        }

    }

    @Override
    public NoteEntity getNoteById(Long noteId) throws DAOException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            NoteEntity note = (NoteEntity) session.get(NoteEntity.class, noteId);
            return note;
        }catch (Exception e){
            throw new DAOException("failed to get note by id");
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
