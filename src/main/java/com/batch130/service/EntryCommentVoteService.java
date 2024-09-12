package com.batch130.service;

import com.batch130.controller.EntryCommentVoteController;
import com.batch130.core.exceptions.ConflictException;
import com.batch130.core.utils.messages.ErrorMessages;
import com.batch130.entity.concretes.EntryCommentVote;
import com.batch130.payload.mappers.EntryCommentVoteMapper;
import com.batch130.payload.request.EntryCommentVoteRequest;
import com.batch130.payload.response.EntryCommentVoteResponse;
import com.batch130.repository.EntryCommentVoteRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Getter
@Setter

public class EntryCommentVoteService {
   private final EntryCommentVoteRepository entryCommentVoteRepository;
   private final EntryCommentVoteMapper commentVoteMapper;




    public EntryCommentVoteResponse add(EntryCommentVoteRequest request) {
        // ayni subject var mi yok mu kontrolu
        if (entryCommentVoteRepository.existsByCreatedBy(request.getCreatedBy())) {
            throw new ConflictException(String.format(ErrorMessages.ALREADY_ENTRY_COMMENT_VOTE_EXISTS_SUBJECT));
       }
        EntryCommentVote commentVote= commentVoteMapper.convertRequestToEntryCommentVote(request);

        return commentVoteMapper.convertEntryCommentVoteToResponse(entryCommentVoteRepository.save(commentVote));
    }




    public ResponseEntity<?> deleteComment(Long commentId) {

        EntryCommentVote entryCommentVote=entryCommentVoteRepository.findById(commentId).orElseThrow(
                ()->{
                    throw new ConflictException(String.format(ErrorMessages.NOT_FOUND_ENTRY_COMMENT_VOTE,commentId));
                });
        entryCommentVoteRepository.delete(entryCommentVote);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);

    }



    public ResponseEntity<EntryCommentVoteResponse> getEntryVoteByCommentId(Long commentId) {

        EntryCommentVote entryCommentVote=entryCommentVoteRepository.findById(commentId).orElseThrow(
                ()->{
           throw new ConflictException(String.format(ErrorMessages.NOT_FOUND_ENTRY_COMMENT_VOTE,commentId));
        });

        return ResponseEntity.ok(commentVoteMapper.convertEntryCommentVoteToResponse(entryCommentVote));

    }


}
