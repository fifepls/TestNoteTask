package com.NoteTest.note.controller;

import com.NoteTest.note.Entity.HashTagEntity;
import com.NoteTest.note.Entity.dto.NoteDTO;
import com.NoteTest.note.service.NoteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/add")
    public void addNote(
                    @RequestParam(value = "title") String title,
                    @RequestParam(value = "text") String text,
                    @RequestBody Set<HashTagEntity> tags){
        noteService.addNote(title, text, tags);
    }

    @PostMapping("/update")
    public void updateNote(
                    @RequestParam(value = "noteId") Long noteId,
                    @RequestParam(value = "title") String title,
                    @RequestParam(value = "text") String text,
                    @RequestBody Set<HashTagEntity> tags){
        noteService.updateNote(noteId,title,text, tags);
    }

    @DeleteMapping("/remove")
    public void removeNote(@RequestParam(value = "removeNoteId") Long removeNoteId){
        noteService.removeNote(removeNoteId);
    }


    @GetMapping("/get")
    public List<NoteDTO> getNotes(){
        return NoteDTO.noteListToNoteDtoList(noteService.getNotes());
    }

    @GetMapping("/get/sorted/date")
    public List<NoteDTO> getSortedNotesByDate(){
        return NoteDTO.noteListToNoteDtoList(noteService.getNotesSortByDate());
    }

    @GetMapping("/get/sorted/tags")
    public List<NoteDTO> getSortedNotesByTags(@RequestBody Set<Long> tagIds){
        return NoteDTO.noteListToNoteDtoList(noteService.getNotesSortByTags(tagIds));
    }


    @GetMapping("/get/contains")
    public List<NoteDTO> getContainsWordNotes(
            @RequestParam(value = "keyWord") String keyWord){
        return NoteDTO.noteListToNoteDtoList(noteService.getNotesThatContainsWord(keyWord));
    }

}
