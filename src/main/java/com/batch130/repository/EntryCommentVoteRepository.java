package com.batch130.repository;

import com.batch130.entity.concretes.EntryCommentVote;
import com.batch130.entity.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryCommentVoteRepository extends JpaRepository<EntryCommentVote,Long > {
    boolean existsByCreatedBy(User createdBy);
}
