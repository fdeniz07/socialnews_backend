package com.batch130.controller;

import com.batch130.entity.concretes.Entry;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.response.EntryResponse;
import com.batch130.service.EntryService;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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









}
