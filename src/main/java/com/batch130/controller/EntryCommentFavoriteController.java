package com.batch130.controller;

import com.batch130.service.EntryCommentFavoriteService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entryCommentFavorite")
@Slf4j
@RequiredArgsConstructor
public class EntryCommentFavoriteController {

    private final EntryCommentFavoriteService service;

    //Not: add() ******************************************************
    @PostMapping("/add")
    public ResponseEntity<?> add(HttpServletRequest httpServlet){
        String email = httpServlet.getRemoteUser();
        return ResponseEntity.ok(service.add(email));
    }

    //Not: delete() ***************************************************
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
