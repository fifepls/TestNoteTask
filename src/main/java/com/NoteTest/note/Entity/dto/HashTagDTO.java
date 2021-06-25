package com.NoteTest.note.Entity.dto;

import com.NoteTest.note.Entity.HashTagEntity;
import java.util.HashSet;
import java.util.Set;

public class HashTagDTO {
    private Long id;
    private String hashTagName;

    public static Set<HashTagDTO> hashTagSetToHashTagDtoList(Set<HashTagEntity> hashTags){
        Set<HashTagDTO> hashTagDTOS = new HashSet<>();
        for (HashTagEntity hashTag : hashTags) {
            hashTagDTOS.add(hashTagToHashTagDto(hashTag));
        }
        return hashTagDTOS;
    }

    public static HashTagDTO hashTagToHashTagDto(HashTagEntity hashTag){
        HashTagDTO hashTagDTO = new HashTagDTO();
        hashTagDTO.setId(hashTag.getId());
        hashTagDTO.setHashTagName(hashTag.getHashTagName());
        return hashTagDTO;
    }

    public HashTagDTO() {
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
}
