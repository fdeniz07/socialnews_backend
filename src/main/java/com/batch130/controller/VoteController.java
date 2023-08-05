package com.batch130.controller;

import com.batch130.service.VoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "VoteController",
        description = "VoteController is responsible for performing operations related to entry votes."
)
@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/add")
    public ResponseEntity<?> addVote(@Valid @RequestBody VoteRequest request) {
        return voteService.addVote(request);
    }


    /**
     * Need to know pageable or not
     * @param id
     * @return page or list
     */
    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllById(@PathVariable("id") Long id) {
        return voteService.getAllById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateVote(
            @PathVariable("id") Long id, @Valid @RequestBody VoteUpdateRequest request
    ) {
        return voteService.updateVote(request);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteVote(@PathVariable("id") Long id) {
        return voteService.deleteVote(id);
    }

}
