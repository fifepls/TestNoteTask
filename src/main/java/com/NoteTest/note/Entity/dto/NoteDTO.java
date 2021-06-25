package com.NoteTest.note.Entity.dto;

import com.NoteTest.note.Entity.NoteEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class NoteDTO {

    private Long id;

    private String title;

    private String noteText;

    private Date createDate;

    private Set<HashTagDTO> tags;


    public static List<NoteDTO> noteListToNoteDtoList(List<NoteEntity> notes){
        List<NoteDTO> noteDTOS = new ArrayList<>();
        for (NoteEntity note : notes) {
            noteDTOS.add(NoteDTO.NoteToNoteDTO(note));
        }
        return noteDTOS;
    }

    public static NoteDTO NoteToNoteDTO(NoteEntity note){
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setNoteText(note.getNoteText());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setCreateDate(note.getCreateDate());
        noteDTO.setTags(HashTagDTO.hashTagSetToHashTagDtoList(note.getTags()));
        return noteDTO;

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

    public Set<HashTagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<HashTagDTO> tags) {
        this.tags = tags;
    }
}
