package com.batch130.controller;

import com.batch130.payload.request.EntryCommentVoteRequest;
import com.batch130.payload.response.EntryCommentVoteResponse;
import com.batch130.service.EntryCommentVoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("entryCommentVote")
public class EntryCommentVoteController {
    private final EntryCommentVoteService entryCommentVoteService;


    @PostMapping("/add")
    public ResponseEntity<EntryCommentVoteResponse> add(@RequestBody @Valid EntryCommentVoteRequest request){
        return ResponseEntity.ok(entryCommentVoteService.add(request));
    }
     @GetMapping("/getEntryByCommentId")
      public ResponseEntity<EntryCommentVoteResponse> getEntryByCommentId(@PathVariable Long commentId){
        return entryCommentVoteService.getEntryVoteByCommentId(commentId);
     }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> delete(@PathVariable Long commentId) {

        return entryCommentVoteService.deleteComment(commentId);
    }

}
