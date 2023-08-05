package com.batch130.service;

import com.batch130.payload.response.EntryResponse;
import com.batch130.repository.EntryCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryCommentService {

    private final EntryCommentRepository repository;

    //Not: update() **************************************************
    public static ResponseEntity<?> update() {
        return null;
    }

    //Not: add() *************************************************
    public String add(String comment) {
        return null;
    }

    //Not: getAllById() *************************************************
    public static List<EntryResponse> getAllById(){
        return null;
    }


    //Not: delete() ************************************************
    public String delete(Long id) {
        return null;
    }

}