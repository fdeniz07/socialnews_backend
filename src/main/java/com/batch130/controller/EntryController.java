package com.batch130.controller;

import com.batch130.core.utils.responseMessage.ResponseMessage;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.request.EntryRequestForSoftDelete;
import com.batch130.payload.response.EntryResponse;
import com.batch130.service.EntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry")
@Slf4j // lSLF4J, Java projelerinde loglama işlevselliğini sağlamak için kullanılan bir loglama arayüzüdür.
@RequiredArgsConstructor
public class EntryController {

    private final EntryService entryService;

    @PostMapping("/add")
    public ResponseEntity<EntryResponse> add(@RequestBody @Valid EntryRequest entryRequest) {

        return ResponseEntity.ok(entryService.add(entryRequest));

    }

    @GetMapping("/getAll")
    public List<EntryResponse> getAllEntry() {

        //!! Pageable olacak - core da tasarlanacak eger olmaz ise //@PageableDefault yapisini kullanabiliriz
        return entryService.getAllEntry();
        //test
    }

    @GetMapping("/getByUserId/{id}")
    public List<EntryResponse> getAllByUserId(@PathVariable Long id) {

        return entryService.getByUserId(id);
    }

    @PutMapping("/update/{entryId}")
    public ResponseMessage<EntryResponse> updateEntry(@PathVariable Long entryId,
                                                      @RequestBody @Valid EntryRequest request) {
        return entryService.update(entryId, request);
    }

    @PutMapping("/delete/{entryId}")
    public ResponseMessage<EntryResponse> deleteEntry(@PathVariable Long entryId,
                                          @RequestBody @Valid EntryRequestForSoftDelete request) {
        return entryService.softDelete(entryId, request);
    }

//    @DeleteMapping("/delete/{entryId}")
//    public ResponseMessage<?> deleteEntry(@PathVariable Long entryId,
//                                          @RequestBody @Valid EntryRequest request) {
//        return entryService.softDelete(entryId, request);
//    }
}
