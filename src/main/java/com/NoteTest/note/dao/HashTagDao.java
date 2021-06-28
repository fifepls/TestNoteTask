package com.NoteTest.note.dao;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.dao.exceptions.DAOException;

import java.util.Set;

public interface HashTagDao {
    public Set<HashTagEntity> getHashTagsByHashTagId(Set<Long> hashTagIds) throws DAOException;
}
