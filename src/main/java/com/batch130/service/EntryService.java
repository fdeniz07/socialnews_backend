package com.batch130.service;

import com.batch130.core.exceptions.ConflictException;
import com.batch130.core.exceptions.ResourceNotFoundException;
import com.batch130.core.utils.messages.ErrorMessages;
import com.batch130.entity.concretes.Entry;
import com.batch130.payload.mappers.EntryMapper;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.response.EntryResponse;
import com.batch130.repository.EntryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class EntryService  implements Serializable {

    private final EntryRepository entryRepository;

    private final EntryMapper entryMapper;



    //NOt: add()***************************************************************


    public EntryResponse add(EntryRequest entryRequest) {

        // ayni subject var mi yok mu kontrolu
     if(entryRepository.existsBySubject(entryRequest.getSubject())){
            new ConflictException(String.format(ErrorMessages.ALREADY_ENTRY_EXISTS_SUBJECT));
     }


       Entry entry = entryMapper.convertEntry(entryRequest);

       return entryMapper.converEntryToResponse(entryRepository.save(entry));

    }


}
