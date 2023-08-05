package com.batch130.service;

import com.batch130.core.exceptions.ConflictException;
import com.batch130.core.exceptions.ResourceNotFoundException;
import com.batch130.core.utils.messages.ErrorMessages;
import com.batch130.entity.concretes.Entry;
import com.batch130.payload.mappers.EntryMapper;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.response.EntryResponse;
import com.batch130.repository.EntryRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class EntryService implements Serializable {

    private final EntryRepository entryRepository;
    private final EntryMapper entryMapper;

    //NOt: add()***************************************************************

    public EntryResponse add(EntryRequest entryRequest) {

        // ayni subject var mi yok mu kontrolu
        if (entryRepository.existsBySubject(entryRequest.getSubject())) {
            throw new ConflictException(String.format(ErrorMessages.ALREADY_ENTRY_EXISTS_SUBJECT));
        }

        Entry entry = entryMapper.convertRequestToEntry(entryRequest);

        return entryMapper.convertEntryToResponse(entryRepository.save(entry));
    }


    public List<EntryResponse> getAllEntry() {

        List<EntryResponse> entries = entryRepository.findAll()
                .stream()
                .map(entryMapper::convertEntryToResponse)
                .collect(Collectors.toList());

        if (entries.isEmpty()) {
            throw new ResourceNotFoundException(String.format(ErrorMessages.ENTRY_NOT_FOUND));
        }
        return entries;
    }
}
