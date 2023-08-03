package com.batch130.payload.mappers;


import com.batch130.entity.concretes.Entry;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.response.EntryResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Data
public class EntryMapper {


    private  ModelMapper modelMapper;

    public EntryResponse converEntryToResponse(Entry entry){

        EntryResponse response = modelMapper.map(entry, EntryResponse.class);


        return response;

    }


    public Entry convertEntry(EntryRequest entryRequest){
        Entry entry = modelMapper.map(entryRequest, Entry.class);
        entry.setCreatedDate(LocalDateTime.now());
        entry.setModifiedDate(LocalDateTime.now());
        entry.setActive(true);
        entry.setDeleted(false);
        return entry;
    }










}
