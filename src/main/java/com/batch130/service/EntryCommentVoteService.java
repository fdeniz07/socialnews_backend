package com.batch130.service;

import com.batch130.controller.EntryCommentVoteController;
import com.batch130.payload.request.EntryCommentVoteRequest;
import com.batch130.payload.response.EntryCommentVoteResponse;
import com.batch130.repository.EntryCommentVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryCommentVoteService {
   private final EntryCommentVoteRepository entryCommentVoteRepository;




    public EntryCommentVoteResponse add(EntryCommentVoteRequest request) {
        return null;
    }
    public ResponseEntity<?> deleteComment(Long commentId) {
      return null;
    }

    public ResponseEntity<EntryCommentVoteResponse> getEntryVoteByCommentId(Long commentId) {
        return null;
    }


}
