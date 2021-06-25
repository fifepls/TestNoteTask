package com.NoteTest.note.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tags")
public class HashTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hashTagName;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "note_tags",
    joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id")
    )
    private Set<NoteEntity> Notes;


    public HashTagEntity() {
    }

    public HashTagEntity(String hashTagName) {
        this.hashTagName = hashTagName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashTagName() {
        return hashTagName;
    }

    public void setHashTagName(String hashTagName) {
        this.hashTagName = hashTagName;
    }

    public Set<NoteEntity> getNotes() {
        return Notes;
    }

    public void setNotes(Set<NoteEntity> notes) {
        Notes = notes;
    }
}
