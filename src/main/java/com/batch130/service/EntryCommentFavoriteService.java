package com.batch130.service;

import com.batch130.repository.EntryCommentFavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryCommentFavoriteService {

    private final EntryCommentFavoriteRepository repository;

    //Not: add() ******************************************************
    public String add(String email) {

        return null;
    }

    //Not: delete() ***************************************************
    public String delete(Long id) {

        return null;
    }

}
