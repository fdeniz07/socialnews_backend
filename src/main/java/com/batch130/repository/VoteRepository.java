package com.batch130.repository;

import com.batch130.entity.concretes.EntryVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<EntryVote, Long> {
}
