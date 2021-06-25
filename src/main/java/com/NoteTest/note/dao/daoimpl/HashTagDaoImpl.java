package com.NoteTest.note.dao.daoimpl;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.dao.HashTagDao;
import com.NoteTest.note.dao.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;


@Component
public class HashTagDaoImpl implements HashTagDao {
    @Override
    public Set<HashTagEntity> getHashTagsByHashTagId(Set<Long> hashTagIds) {
        Session session = HibernateUtil.getSession();
        Set<HashTagEntity> hashTags = new HashSet<>();
        for (Long hashTagId : hashTagIds) {
            hashTags.add(session.get(HashTagEntity.class, hashTagId));
        }
        session.close();
        return hashTags;
    }
}
