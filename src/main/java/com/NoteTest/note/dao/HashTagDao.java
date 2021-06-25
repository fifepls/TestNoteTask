package com.NoteTest.note.dao;

import com.NoteTest.note.Entity.HashTagEntity;

import java.util.Set;

public interface HashTagDao {
    public Set<HashTagEntity> getHashTagsByHashTagId(Set<Long> hashTagIds);
}
