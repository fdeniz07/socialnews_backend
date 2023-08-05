package com.batch130.service;

import com.batch130.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    public ResponseEntity<?> addVote(VoteRequest request) {
        return null;
    }


    public ResponseEntity<?> getAllById(Long id) {
        return null;
    }

    public ResponseEntity<?> updateVote(VoteUpdateRequest request) {
        return null;
    }

    public ResponseEntity<?> deleteVote(Long id) {
        return null;
    }


}
