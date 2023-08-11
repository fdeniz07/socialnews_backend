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

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class EntryService implements Serializable {

    private final EntryRepository entryRepository;
    private final UserService userService;
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

    public List<EntryResponse> getByUserId(Long id) {

        //!! Bu id kullanici sistemde mevcut mu kontrolü
        User user = userService.findById(id);

        return entryRepository.findAllByUserId(id)
                .stream()
                .map(entryMapper::convertEntryToResponse)
                .collect(Collectors.toList());
    }

    public ResponseMessage<EntryResponse> update(Long entryId, EntryRequest request) {

        //Entry var mi kontrolü
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ENTRY_NOT_FOUND));

        Entry updatedEntry = entryMapper.convertRequestToEntryUpdate(request,entryId);
        entryRepository.save(updatedEntry);

        return ResponseMessage.<EntryResponse>builder()
                .object(entryMapper.convertEntryToResponse(updatedEntry))
                .message(SuccessMessages.ENTRY_SUCCESSFULLY_UPDATED)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public ResponseMessage<EntryResponse> softDelete(Long entryId, EntryRequestForSoftDelete request) {

        //Entry var mi kontrolü
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ENTRY_NOT_FOUND));

        Entry softDeletedEntry = entryMapper.convertRequestToEntryForSoftDelete(request,entryId);

        return ResponseMessage.<EntryResponse>builder()
                .object(entryMapper.convertEntryToResponse(softDeletedEntry))
                .message(SuccessMessages.ENTRY_SUCCESSFULLY_DELETED)
                .httpStatus(HttpStatus.OK)
                .build();
    }

//    public ResponseMessage<?> softDelete(Long entryId,EntryRequest request) {
//
//        //Entry var mi kontrolü
//        Entry entry = entryRepository.findById(entryId)
//                .orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ENTRY_NOT_FOUND));
//
//        Entry softDeletedEntry = entryMapper.convertRequestToEntryForSoftDelete(request,entryId);
//
//        return ResponseMessage.<EntryResponse>builder()
//                .object(entryMapper.convertEntryToResponse(softDeletedEntry))
//                .message(SuccessMessages.ENTRY_SUCCESSFULLY_UPDATED)
//                .httpStatus(HttpStatus.OK)
//                .build();
//    }
}
