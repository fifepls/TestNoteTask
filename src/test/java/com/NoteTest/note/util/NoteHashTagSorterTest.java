package com.NoteTest.note.util;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.NoteEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NoteHashTagSorterTest {


    private NoteHashTagSorter hashTagSorter = new NoteHashTagSorter();

    @Test
    void sortNotesByTags() {

        //valid sorted with ids is 3,1,2;

        List<NoteEntity> notes = new ArrayList<>();

        NoteEntity note1 = new NoteEntity(1L,"title1","text1", new Date(),
                Set.of(new HashTagEntity("4"),new HashTagEntity("5")));

        NoteEntity note2 = new NoteEntity(2L,"title2","text2", new Date(),
                Set.of(new HashTagEntity("1")));

        NoteEntity note3 = new NoteEntity(3L,"title3","text3", new Date(),
                Set.of(new HashTagEntity("4"),new HashTagEntity("5"),new HashTagEntity("6")));

        notes.add(note1);
        notes.add(note2);
        notes.add(note3);

        Set<HashTagEntity> tags = Set.of(new HashTagEntity(1L,"5",Set.of(note1,note3)),
                new HashTagEntity(2L,"4",Set.of(note1,note3)),
                new HashTagEntity(3L,"6",Set.of(note3)),
                new HashTagEntity(4L,"1",Set.of(note2))
                );

        List<NoteEntity> sorted = hashTagSorter.sortNotesByTags(notes,tags);

        List<NoteEntity> expected = Stream.of(note3,note1,note2).collect(Collectors.toList());


        Assertions.assertEquals(sorted,expected);
        Assertions.assertNotEquals(notes,sorted);
    }
}