package com.batch130.controller;

import com.batch130.entity.concretes.Entry;
import com.batch130.entity.concretes.EntryComment;
import com.batch130.payload.response.EntryResponse;
import com.batch130.service.EntryCommentFavoriteService;
import com.batch130.service.EntryCommentService;
import com.batch130.service.EntryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entrycomment")
@RequiredArgsConstructor
public class EntryCommentController {

    private final EntryCommentService service;



    // Not :  Delete() ****************************************************
    @DeleteMapping("/delete/{entryComment}")
    public ResponseEntity<?> deleteEntryComment(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));

    }

    // Not :  getAllById() ************************************************************************

    @GetMapping("getAllById")
    public List<EntryResponse> getAllById(){
        return EntryCommentService.getAllById();
    }

    // Not :  update() ************************************************************************
    @PutMapping("/update/{entryCommentId}")
    public ResponseEntity<?> update(@RequestBody @Valid Update entryCommentRequest, @PathVariable Long EntryCommentId){
        return EntryCommentService.update();
    }


    // Not :  add() ************************************************************************
    @PostMapping("/add")
    public ResponseEntity<?> add(HttpServletRequest httpServlet){
        String email = httpServlet.getRemoteUser();
        return ResponseEntity.ok(service.add(email));
    }



}
