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

    public ResponseEntity<EntryCommentVoteResponse> update(EntryCommentVoteRequest request, Long commentId) {
     return  entryCommentVoteRepository.save();
    }


    public EntryCommentVoteResponse add(EntryCommentVoteRequest request) {
        return entryCommentVoteRepository.save();
    }
    public ResponseEntity<?> deleteComment(Long commentId) {
      return entryCommentVoteRepository.deleteById();
    }

    public ResponseEntity<EntryCommentVoteResponse> getEntryVoteByCommentId(Long commentId) {
        return entryCommentVoteRepository.findById();
    }


}
