package com.NoteTest.note.util;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import org.springframework.stereotype.Component;
import java.util.*;

/*
 *Sorting notes by amount of note contains tags
 *
 * if note contains 5 tags and 3 of them from a tags,
 * then it will ne have more weight than note with that contains 2 tags
 *
 */


@Component
public class NoteHashTagSorter {
    public List<NoteEntity> sortNotesByTags(List<NoteEntity> notes, Set<HashTagEntity> tags){
        Map<NoteEntity,Long> notesMap = new HashMap<>();
        for (NoteEntity note : notes) {
            Long counter = 0L;
            for (HashTagEntity tag : note.getTags()) {
                if(note.getTags().contains(tag)){
                    counter++;
                }
            }
            notesMap.put(note,counter);
        }

        List<NoteEntity> sortedNotes = new ArrayList<>();
        while (!notesMap.isEmpty()){

            NoteEntity currentNote = getKeyByMaxValueFromMap(notesMap);
            notesMap.remove(currentNote);
            sortedNotes.add(currentNote);
        }

        return sortedNotes;
    }


    private NoteEntity getKeyByMaxValueFromMap(Map<NoteEntity,Long> notesMap){
        NoteEntity noteEntity = notesMap.entrySet().iterator().next().getKey();
        Long maxValue = 0L;
        for(Map.Entry<NoteEntity,Long> entry : notesMap.entrySet()){
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                noteEntity = entry.getKey();
            }
        }

        return noteEntity;
    }
}
