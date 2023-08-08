package com.batch130.controller;

import com.batch130.payload.request.EntryRequest;
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
    public ResponseEntity<EntryResponse> add(@RequestBody @Valid EntryRequest entryRequest){

        return ResponseEntity.ok(entryService.add(entryRequest));

    }

    @GetMapping("/getAll")
    public List<EntryResponse> getAllEntry(){

        //!! Pageable olacak - core da tasarlanacak eger olmaz ise //@PageableDefault yapisini kullanabiliriz
        return entryService.getAllEntry();
    }







}
