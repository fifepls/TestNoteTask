package com.NoteTest.note.dao.daoimpl;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.dao.HashTagDao;
import com.NoteTest.note.dao.HibernateUtil;
import com.NoteTest.note.dao.exceptions.DAOException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;


@Component
public class HashTagDaoImpl implements HashTagDao {
    @Override
    public Set<HashTagEntity> getHashTagsByHashTagId(Set<Long> hashTagIds) throws DAOException {
        Session session = null;
        try {
            session =  HibernateUtil.getSession();
            Set<HashTagEntity> hashTags = new HashSet<>();
            for (Long hashTagId : hashTagIds) {
                hashTags.add(session.get(HashTagEntity.class, hashTagId));
            }
            return hashTags;
        }catch (Exception e){
            throw new DAOException("failed to get hash tags by hash tag id");
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
