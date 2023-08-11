package com.batch130.service;

import com.batch130.core.exceptions.ConflictException;
import com.batch130.core.exceptions.ResourceNotFoundException;
import com.batch130.core.utils.messages.ErrorMessages;
import com.batch130.core.utils.messages.SuccessMessages;
import com.batch130.core.utils.responseMessage.ResponseMessage;
import com.batch130.entity.concretes.Entry;
import com.batch130.entity.concretes.User;
import com.batch130.payload.mappers.EntryMapper;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.request.EntryRequestForSoftDelete;
import com.batch130.payload.response.EntryResponse;
import com.batch130.repository.EntryRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Transactional //Update ve delete islemlerinde kullanmak gerekli
public class EntryService implements Serializable {

    private final EntryRepository entryRepository;
    private final UserService userService;
    private final EntryMapper entryMapper;

    //NOT: add()***************************************************************
    public EntryResponse add(EntryRequest entryRequest) {

        // ayni subject var mi yok mu kontrolu
        if (entryRepository.existsBySubject(entryRequest.getSubject())) {
            throw new ConflictException(String.format(ErrorMessages.ALREADY_ENTRY_EXISTS_SUBJECT));
        }

        Entry entry = entryMapper.convertRequestToEntry(entryRequest);

        return entryMapper.convertEntryToResponse(entryRepository.save(entry));
    }

    //NOT: getAllEntry()***************************************************************
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

    //NOT: getByUserEntry()***************************************************************
    public List<EntryResponse> getByUserId(Long id) {

        //!! Bu id kullanici sistemde mevcut mu kontrolü
        User user = userService.findById(id);

        return entryRepository.findAllByUserId(id)
                .stream()
                .map(entryMapper::convertEntryToResponse)
                .collect(Collectors.toList());
    }

    //NOT: update()***************************************************************
    public ResponseMessage<EntryResponse> update(Long entryId, EntryRequest request) {

        //Entry var mi kontrolü
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ENTRY_NOT_FOUND));

        Entry updatedEntry = entryMapper.convertRequestToEntryUpdate(request, entryId);
        entryRepository.save(updatedEntry);

        return ResponseMessage.<EntryResponse>builder()
                .object(entryMapper.convertEntryToResponse(updatedEntry))
                .message(SuccessMessages.ENTRY_SUCCESSFULLY_UPDATED)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    //NOT: softDelete()***************************************************************
    public ResponseMessage<EntryResponse> softDelete(Long entryId) {

        //Entry var mi kontrolü
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ENTRY_NOT_FOUND));

        //!!!Softdelete islemlerinde verinin silinmesi söz konusu degildir. Bu nedenle verinin görünürlügü update islemi yapar gibi degistirilir.
       entryRepository.softDeletedById(entryId);

        return ResponseMessage.<EntryResponse>builder()
                .message(SuccessMessages.ENTRY_SUCCESSFULLY_DELETED)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    //NOT: hardDelete()***************************************************************
    public ResponseMessage<?> hardDelete(Long entryId) {

        //Entry var mi kontrolü
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ENTRY_NOT_FOUND));

        entryRepository.deleteById(entryId);

        return ResponseMessage.<EntryResponse>builder()
                .message(SuccessMessages.ENTRY_SUCCESSFULLY_DELETED_FROM_DATABASE)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
