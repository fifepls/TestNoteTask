package com.NoteTest.note.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "notes")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String noteText;

    private Date createDate;

    @Column(name = "tags")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "note_tags",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )

    private Set<HashTagEntity> tags;


    public NoteEntity() {
    }

    public NoteEntity(Long id, String title, String noteText, Date createDate, Set<HashTagEntity> tags) {
        this.id = id;
        this.title = title;
        this.noteText = noteText;
        this.createDate = createDate;
        this.tags = tags;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<HashTagEntity> getTags() {
        return tags;
    }

    public void setTags(Set<HashTagEntity> tags) {
        this.tags = tags;
    }
}
