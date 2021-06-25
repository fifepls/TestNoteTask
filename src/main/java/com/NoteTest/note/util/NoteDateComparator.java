package com.NoteTest.note.util;

import com.NoteTest.note.Entity.NoteEntity;
import org.springframework.stereotype.Component;
import java.util.Comparator;

@Component
public class NoteDateComparator implements Comparator<NoteEntity> {
    @Override
    public int compare(NoteEntity o1, NoteEntity o2) {
        if(o1.getCreateDate().before(o2.getCreateDate())){
            return -1;
        }else if(o2.getCreateDate().after(o2.getCreateDate())){
            return 1;
        }
        return 0;
    }
}