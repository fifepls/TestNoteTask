package com.NoteTest.note.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "notes")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String noteText;

    private String createDate;

    @Column(name = "tags")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "note_tags",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<HashTagEntity> tags;


    public NoteEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Set<HashTagEntity> getTags() {
        return tags;
    }

    public void setTags(Set<HashTagEntity> tags) {
        this.tags = tags;
    }
}
